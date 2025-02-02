package paka.tinder.tinder.Service;

import paka.tinder.tinder.Secure.BillCipher;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Map;

public class SecureDataTransferServerService {
    private ArrayList<BillCipher> billCipherList = new ArrayList<>();

    public Integer getPublicKeyFromClient(String publicKeyClientStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //Every client gets his own id, that identify him in our system
        //This id is stored encrypted on client side
        PublicKey publicKeyClient = convertStringToKey(publicKeyClientStr);
        BillCipher billCipherServer = new BillCipher(publicKeyClient);
        billCipherList.add(billCipherServer);
        //Returning index of billCipher object
        return billCipherList.size();
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
