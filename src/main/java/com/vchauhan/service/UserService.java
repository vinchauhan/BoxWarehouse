package com.vchauhan.service;

import com.vchauhan.domain.User;
import com.vchauhan.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vineet on 9/12/16.
 */

public interface UserService {

    List <User> findAll();
    Optional<User> findOne(String id);
    void delete(String id);
    User findByUsername(String username);
    void save(User user);


}
