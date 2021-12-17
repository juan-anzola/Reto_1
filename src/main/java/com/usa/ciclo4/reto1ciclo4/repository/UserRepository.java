package com.usa.ciclo4.reto1ciclo4.repository;

import com.usa.ciclo4.reto1ciclo4.crud.UserCrud;
import com.usa.ciclo4.reto1ciclo4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrud userCrud;

    public List<User> getAll() {
        return (List<User>) userCrud.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrud.findById(id);
    }

    public User save(User user) {
        return userCrud.save(user);
    }

    public boolean emailExists(String email) {
        Optional<User> tmpUser = userCrud.findByEmail(email);

        return !tmpUser.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userCrud.findByEmailAndPassword(email, password);
    }
}
