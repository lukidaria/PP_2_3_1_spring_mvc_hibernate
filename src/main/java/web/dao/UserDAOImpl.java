package web.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public User add(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        User user = entityManager.find(User.class, userId);

        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.remove(entityManager.merge(user));
        }
    }

    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void update(User user) {
        User entity = getUser(user.getId());
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setLastName(user.getLastName());
        entity.setAge(user.getAge());

//        entityManager.merge(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
       return entityManager.createQuery("from User").getResultList();
    }
}
