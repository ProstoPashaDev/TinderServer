package paka.tinder.tinder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Class representing table in database
 */
@Entity
@Table(name = "tableName")
public class TableClassExample {
    //Primary key
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    //@Column(name = "surname")
    private String surname;

    //some getters and setters

    public int getId() {
        return id;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
