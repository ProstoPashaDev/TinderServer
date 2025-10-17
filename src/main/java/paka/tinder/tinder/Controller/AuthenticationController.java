package paka.tinder.tinder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import paka.tinder.tinder.Database.UserDAO;
import paka.tinder.tinder.Database.User;

@RestController
public class AuthenticationController {

    @Autowired
    UserDAO userDAO;

    @PostMapping(value = "/register")
    public ResponseEntity<HttpStatus> registerUser(@RequestBody User user) {
        try {
            userDAO.insertUser(user);
            //System.out.println(userDAO.findByEmail(user.getEmail()).getPassword());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/authorize")
    public ResponseEntity<HttpStatus> authorizeUser(@RequestBody User user) {
        User userFromDb = userDAO.findByEmail(user.getEmail());
        if (userFromDb != null && userFromDb.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
