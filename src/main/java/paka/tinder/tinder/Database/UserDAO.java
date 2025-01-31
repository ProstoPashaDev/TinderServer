package paka.tinder.tinder.Database;

import org.hibernate.Session;
import paka.tinder.tinder.User;

public class UserDAO {
    private final Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public void insertUser(User user) {
        session.beginTransaction();
        session.persist(user); //insert
        session.getTransaction().commit();
    }

    public User findByLogin(String login) {
        return session.get(User.class, login);
    }


}
