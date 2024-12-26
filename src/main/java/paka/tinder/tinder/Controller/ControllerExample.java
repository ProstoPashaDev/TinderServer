package paka.tinder.tinder.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class for getting requests from client
 * (realize @GetMapping or @PostMapping etc. methods)
 */
@RestController
public class ControllerExample {

    /**
     * Listen on address: http://localhost:8080/
     * 1) ResponseEntity<YourType>
     * 2) new ResponseEntity<>(YourTypeObject, HttpStatus)
     * @return some trash
     */
    @GetMapping(value = "/")
    private ResponseEntity<String> method() {

        return new ResponseEntity<>("Hello Pasha assistant", HttpStatus.OK);
    }

    /**
     * Example with id in address
     * @param id
     * @return your iq
     */
    @GetMapping(value = "/{id}")
    private ResponseEntity<String> method2(@PathVariable(name = "id") int id) {

        return new ResponseEntity<>("Hello Pasha assistant, your iq is " + id, HttpStatus.OK);
    }

    /**
     * Example with @RequestBody. If you get "Whitelabel Error Page" do not worry,
     * you just didn`t pass String in input parameters
     * @param id
     * @param str
     * @return
     */
    @GetMapping(value = "/pashka/{id}")
    private ResponseEntity<String> method3(@PathVariable(name = "id") int id, @RequestBody String str) {

        return new ResponseEntity<>(str + " " + id, HttpStatus.OK);
    }

}
