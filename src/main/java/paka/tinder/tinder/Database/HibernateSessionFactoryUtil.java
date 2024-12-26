package paka.tinder.tinder.Database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import paka.tinder.tinder.TableClassExample;

/**
 * Class for initializing session
 * We initialize it 1 time, then just reuse it
 */
public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        //Initializing sesseionFactory
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                //Add class "pattern"
                configuration.addAnnotatedClass(TableClassExample.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        }
        return sessionFactory;
    }
}
