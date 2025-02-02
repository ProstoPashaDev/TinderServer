package paka.tinder.tinder.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import paka.tinder.tinder.Secure.BillCipher;
import paka.tinder.tinder.Service.SecureDataTransferServerService;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class RegAuthController {

    SecureDataTransferServerService sdtService = new SecureDataTransferServerService();

    @PostMapping(value = "/getPublicKey")
    public ResponseEntity<Integer> getPubicKeyFromClient(@RequestBody String publicKeyClient) {
        //PublicKey is given via byte[], converted to String, because of problem with directly sending PublicKey
        try {
            //Return index of exact billCipher object
            return new ResponseEntity<>(sdtService.getPublicKeyFromClient(publicKeyClient), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
