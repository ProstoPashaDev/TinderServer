package paka.tinder.tinder.Service;

import paka.tinder.tinder.Secure.BillCipher;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Map;

public class SecureDataTransferServerService {
    private ArrayList<BillCipher> billCipherList = new ArrayList<>();

    public Map<Integer, byte[]> getPublicKeyFromClient(Map<Integer, byte[]> pairKeyIndexClient) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //Every client gets his own id, that identify him in our system
        //This id is stored encrypted on client side
        byte[] bytePubKey = pairKeyIndexClient.get(-1);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PublicKey publicKeyClient = factory.generatePublic(new X509EncodedKeySpec(bytePubKey));
        System.out.println(publicKeyClient);
        BillCipher billCipherServer = new BillCipher(publicKeyClient);
        PublicKey publicKeyServer = billCipherServer.generateKeys();
        billCipherList.add(billCipherServer);

        return Map.of(billCipherList.size(), publicKeyServer.getEncoded());
    }
}
