package com.vchauhan.web;

import com.vchauhan.domain.User;
import com.vchauhan.service.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Vineet on 9/12/16.
 */
@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user",
    method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
    private Object createUser(@RequestBody User user) throws URISyntaxException{

        log.info("Rest request to save User : {}"+ user);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private List<User> getUsers() throws URISyntaxException{

        log.info("Rest request to get Users : {}");
        return userService.findAll();

    }
}
