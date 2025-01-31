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

    @PostMapping(value = "/getPublicKey")
    public ResponseEntity<Map<Integer, byte[]>> getPubicKeyFromClient(@RequestBody Map<Integer, byte[]> pairKeyIndexClient) {
        //PublicKey is given via byte[] because of problem with translating PublicKey into httpRequest
        SecureDataTransferServerService sdtService = new SecureDataTransferServerService();
        try {
            return new ResponseEntity<>(sdtService.getPublicKeyFromClient(pairKeyIndexClient), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
