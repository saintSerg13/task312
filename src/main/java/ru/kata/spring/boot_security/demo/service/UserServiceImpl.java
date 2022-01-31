package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.dao.UserDAO;


import java.util.List;

@Component
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUser(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }
}
