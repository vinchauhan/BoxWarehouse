package com.vchauhan.service;

import com.vchauhan.domain.Box;
import com.vchauhan.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vineet on 9/16/16.
 */
public interface BoxService {

    List<Box> findAll();
    Box findOne(Long id);
    void delete(Long id);
    List<Box> findByBoxCode(String boxcode);
    void save(Box box);
    Box findBoxByUser(User user);
}
