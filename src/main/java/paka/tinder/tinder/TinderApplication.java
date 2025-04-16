package paka.tinder.tinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import paka.tinder.tinder.Secure.BillCipher;

import java.security.PublicKey;
import java.util.Timer;

/**
 * Start/main class
 */
@SpringBootApplication
@EntityScan("paka.tinder.tinder")
public class TinderApplication {

    public static void main(String[] args) {
//        BillCipher billCipher = new BillCipher();
//        //billCipher.generateKeys();
//        billCipher = new BillCipher();
//        PublicKey key = billCipher.generateKeys();
//        billCipher.setPublicKey(key);
//        long time1 = System.currentTimeMillis();
//        int count = 0;
//        User user = new User();
//        user.setEmail("p.khramov@innopolis.university");
//        user.setPassword("asbjfajfshash*&&^^%^tuasfgbahyYGHFD&^&");
//        user.setUserId(10^9);
//        while (System.currentTimeMillis() - time1 < 1000) {
//            String str = billCipher.Encrypt(user);
//            User usr = billCipher.Decrypt(str,User.class);
//            count++;
//        }
//        System.out.println(count);


        //Turn on server
        SpringApplication.run(TinderApplication.class, args);

    }

}
