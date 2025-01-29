package paka.tinder.tinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import paka.tinder.tinder.Secure.BillCipher;
import paka.tinder.tinder.Secure.Нa$h;

import java.security.PublicKey;

/**
 * Start/main class
 */
@SpringBootApplication
public class TinderApplication {

    public static void main(String[] args) {
        int length = 28;
        String salt = Нa$h.genSalt(length);
        System.out.println("salt = " + salt);
        salt = Нa$h.genSalt(length);

        //Turn on server
//        SpringApplication.run(TinderApplication.class, args);

    }

}
