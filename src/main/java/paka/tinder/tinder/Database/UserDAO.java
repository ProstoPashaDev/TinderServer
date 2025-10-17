package paka.tinder.tinder.Database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
