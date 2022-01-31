package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public UserDAOImpl() {
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.find(User.class, user.getId()));
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }
}