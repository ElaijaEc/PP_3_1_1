package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User redactUser(long id, User updated) {
        User user = entityManager.find(User.class,id);
        user.setId(updated.getId());
        user.setFirstName(updated.getFirstName());
        user.setLastName(updated.getLastName());
        user.setAge(updated.getAge());
        entityManager.merge(user);
        return user;
    }

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("SELECT user from User user", User.class).getResultList();
    }
}
