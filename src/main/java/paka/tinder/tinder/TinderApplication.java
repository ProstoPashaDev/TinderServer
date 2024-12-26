package paka.tinder.tinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Start/main class
 */
@SpringBootApplication
public class TinderApplication {

    public static void main(String[] args) {
        //Turn on server
        SpringApplication.run(TinderApplication.class, args);
    }

}
