package com.vchauhan.service.impl;

import com.vchauhan.domain.User;
import com.vchauhan.repository.UserRepository;
import com.vchauhan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vineet on 9/12/16.
 */
@Service
public class UserServiceImpl implements UserService {


    Logger log = LoggerFactory.getLogger(UserService.class);

   @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOne(String id) {
        return null;
    }


    @Override
    public void delete(String id) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void save(User user) {

        if(user.getId() != null){
            log.info("Cannot create a user : "+ user.getUsername()+ " already exists");
        }
        log.info("user id : "+ user.getId());
        log.info("user name : "+ user.getUsername());
        //hashing the password
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
