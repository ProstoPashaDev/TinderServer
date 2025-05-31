package paka.tinder.tinder;

import jakarta.persistence.*;

import java.io.Serializable;


/**
 * @Author Pavel
 * Class representing User in database
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "email")
    private String email;
    private String password;

    //Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
