package paka.tinder.tinder.Service;

import paka.tinder.tinder.Secure.BillCipher;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;

public class SecureDataTransferServerService {
    private ArrayList<BillCipher> billCipherList = new ArrayList<>();

    private ArrayList<String> signatureList = new ArrayList<>();

    private final Random RANDOM = new Random();
    private final Integer MIN_SIGN_LENGTH = 7;
    private final Integer MAX_SIGN_LENGTH = 10;

    //TODO change length (number of clients) ~10**8
    private final Integer MAX_NUMBER_OF_CLIENTS = 10;

    public Integer getPublicKeyFromClient(String publicKeyClientStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //Every client gets his own id, that identify him in our system
        //This id is stored encrypted on client side
        PublicKey publicKeyClient = convertStringToKey(publicKeyClientStr);
        BillCipher billCipherServer = new BillCipher(publicKeyClient);
        billCipherList.add(billCipherServer);
        //Checking for list overloading
        /*
        refreshBillCipherList(billCipherServer);
         */
        //Returning index of billCipher object
        return billCipherList.size() - 1;
    }
    public String getPublicKeyInStr(int id) {
        //Sometimes returning different key, if arraylist refreshed
        BillCipher billCipherClient = getBillCipherClient(id);
        String encryptedPublicKeyServer = billCipherClient.Encrypt(billCipherClient.getPublicKey());
        return encryptedPublicKeyServer;
    }

    public String getSignature(int id) {
        if (signatureList.isEmpty()) initializeSignatureList();
        BillCipher billCipherClient = getBillCipherClient(id);
        String encryptedSignature = billCipherClient.Encrypt(signatureList.get(id));
        return encryptedSignature;
    }
    private BillCipher getBillCipherClient(int id) {
        return billCipherList.get(Math.min(billCipherList.size() - 1, id));
    }

    private void initializeSignatureList() {
        for (int i = 0; i < MAX_NUMBER_OF_CLIENTS; i++) {
            signatureList.add(String.valueOf(RANDOM.nextInt((int)Math.pow(10, MIN_SIGN_LENGTH), (int)Math.pow(10, MAX_SIGN_LENGTH))));
        }
    }
    //TODO add timeout deleting elements
    //TODO optimization via null elements, and then creating new ArrayList
    public void deleteBillCipher(int id) {
        billCipherList.remove(id);
        billCipherList.forEach(System.out::println);
    }

    public boolean testConnection(int id, String encryptedSignatureFromClient) {
        //String that checks whether signature from client matches with server one
        return getBillCipherClient(id).Decrypt(encryptedSignatureFromClient, String.class).equals(signatureList.get(id));
    }

    public String convertKeyToString(PublicKey publicKey) {
        byte[] bytePublicKey = publicKey.getEncoded();
        //Converting byte[] to String
        return Base64.getEncoder().encodeToString(bytePublicKey);
    }
    public PublicKey convertStringToKey(String strKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytePublicKey  = Base64.getDecoder().decode(strKey);
        //Converting byte[] to PublicKey
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(new X509EncodedKeySpec(bytePublicKey));
    }
}
