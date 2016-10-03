package com.vchauhan.domain;

import com.vchauhan.BoxWarehouseApiApplicationTests;
import com.vchauhan.repository.BoxRepository;
import com.vchauhan.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Vineet on 9/17/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertUser(){
        User user = new User();
        user.setUsername("vchauhan");
        user.setPassword(new BCryptPasswordEncoder().encode("password"));
        user.setFirstname("Vineet");
        user.setLastname("Chauhan");
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);

        User newUser = userRepository.findOne(user.getId());
        assertNotNull(newUser);

    }

}
