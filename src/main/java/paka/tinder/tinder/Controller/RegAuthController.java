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

    @PostMapping(value = "/sendPublicKey")
    public ResponseEntity<Integer> getPubicKeyFromClient(@RequestBody String publicKeyClient) {
        //PublicKey is given via byte[], converted to String, because of problem with directly sending PublicKey
        try {
            //Return index of exact billCipher object
            return new ResponseEntity<>(sdtService.getPublicKeyFromClient(publicKeyClient), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/getPublicKey")
    public ResponseEntity<String> sendPublicKeyToClient(@RequestBody String id) {
        //Returning type, that we get, that is why id is string
        return new ResponseEntity<>(sdtService.getPublicKeyInStr(Integer.parseInt(id)), HttpStatus.OK);
    }

    @PostMapping(value = "/getSignature")
    public ResponseEntity<String> sendSignatureToClient(@RequestBody String id) {
        return new ResponseEntity<>(sdtService.getSignature(Integer.parseInt(id)), HttpStatus.OK);
    }

    @PostMapping(value = "/testConnection/{id}")
    public ResponseEntity<String> testConnection(@PathVariable(name = "id") String id, @RequestBody String encryptedSignature) {
        return sdtService.testConnection(Integer.parseInt(id), encryptedSignature) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @DeleteMapping(value = "/closeSession/{id}")
    public HttpStatus closeSession(@PathVariable(name = "id") String id) {
        System.out.println(id);
        sdtService.deleteBillCipher(Integer.parseInt(id));
        return HttpStatus.OK;
    }
}
