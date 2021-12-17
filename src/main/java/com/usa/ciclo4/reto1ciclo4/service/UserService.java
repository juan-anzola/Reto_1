package com.usa.ciclo4.reto1ciclo4.service;

import com.usa.ciclo4.reto1ciclo4.model.User;
import com.usa.ciclo4.reto1ciclo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            if (emailExists(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> tmpUser = userRepository.authenticateUser(email, password);

        if (tmpUser.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return tmpUser.get();
        }
    }
}
