package ivan.samoylov;

import ivan.samoylov.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateStorage implements Storage {

    private SessionFactory sessionFactory;
    public HibernateStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void close() {
        sessionFactory.close();
    }

    public int removeAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = String.format("DELETE FROM %s", User.class.getSimpleName());
            Query query = session.createQuery(hql);
            int count = query.executeUpdate();
            transaction.commit();
            return count;
        }
    }


    public User removeUser(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("DELETE User WHERE id = :id ", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
    }


    public User removeUserByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("DELETE User WHERE name = :name ", User.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }
    }

    
    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    
    public void updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    
    public User getUser(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("FROM User WHERE id = :id ", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
    }

    
    public List<User> getAllUsers() {
            return null;
    }
}
