package paka.tinder.tinder.Database;

import jakarta.persistence.*;

/**
 * @Author Pavel
 * Class representing user`s Post in database
 */
@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @Column(name = "post_id")
    private int postId;
    @Column(name = "user_id")
    private int userId;
    private String text;
    private String image;

    //Getters and setters
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
