package paka.tinder.tinder.Database;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import paka.tinder.tinder.User;

@Repository
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertUser(User user) {
        if (findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User with such email already exists");
        }
        entityManager.persist(user);
        entityManager.flush();
    }

    public User findByEmail(String email) {
        return entityManager.find(User.class, email);
    }


}
