package paka.tinder.tinder.Database;

import org.hibernate.Session;
import paka.tinder.tinder.TableClassExample;

import java.util.List;

/**
 * Data access object
 * Aim: process queries to database
 */
public class DAOExample {

    private Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    /**
     * Example of selecting by id (without transaction (group of queries))
     * @param id
     * @return instance of class TableClassExample
     */
    public TableClassExample findById(int id) {
        return session.get(TableClassExample.class, id);
    }

    /**
     * Saving instance of class to database
     * with transaction (group of queries)
     * (in this example group of 1 query)
     * @param example
     */
    public void save(TableClassExample example) {
        session.beginTransaction();
        session.persist(example); //insert
        session.getTransaction().commit();
    }

    /**
     *  Update is like we take class, change parameters and that`s all
     * @param ExampleNew
     * @return indicates whether query processed successfully or not
     */
    public boolean update(TableClassExample ExampleNew) {
        try {
            session.beginTransaction();
            //Getting instance of class, that we need tp update
            TableClassExample exampleOld = findById(ExampleNew.getId());
            //Update parameters
            exampleOld.setName(ExampleNew.getName());
            exampleOld.setSurname(ExampleNew.getSurname());
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Another example with deleting object
     * @param id
     * @return
     */
    public boolean delete(int id) {
        try {
            session.beginTransaction();
            session.remove(findById(id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Example of 50/50 sql query in hibernate
     * P.S. Сам не до конца разобрался, но так можно
     * @return SELECT * FROM TableName -> List of all objects in databasex
     */
    public List<TableClassExample> findAll() {
        return (List<TableClassExample>) session.createQuery("from TableName").list();
    }


}
