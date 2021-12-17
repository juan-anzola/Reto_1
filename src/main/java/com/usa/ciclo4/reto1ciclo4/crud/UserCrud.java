package com.usa.ciclo4.reto1ciclo4.crud;

import com.usa.ciclo4.reto1ciclo4.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrud extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
