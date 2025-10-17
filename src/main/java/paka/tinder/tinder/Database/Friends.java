package paka.tinder.tinder.Database;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "friends")
public class Friends {

    @Id
    public int user_id1;
    @Id
    public int user_id2;
    public String status;
}
