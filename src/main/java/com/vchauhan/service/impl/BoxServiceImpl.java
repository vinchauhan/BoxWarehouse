package com.vchauhan.service.impl;

import com.vchauhan.domain.Box;
import com.vchauhan.domain.User;
import com.vchauhan.repository.BoxRepository;
import com.vchauhan.service.BoxService;
import com.vchauhan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
/**
 * Created by Vineet on 9/16/16.
 */
public class BoxServiceImpl implements BoxService {

    Logger log = LoggerFactory.getLogger(BoxService.class);

    @Autowired
    BoxRepository boxRepository;

    @Override
    public List<Box> findAll() {
        return boxRepository.findAll();
    }

    @Override
    public Box findOne(Long id) {
        Box box = boxRepository.findOne(id);
        return box;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Box> findByBoxCode(String boxcode) {

        return null;
    }

    @Override
    public void save(Box box) {

        if(box != null){
            log.info("Saving a box {}" + box.getBoxCode());
            boxRepository.save(box);
        }
        else {
            log.info("Cannot save an empty Box Object");
        }

    }

    @Override
    public Box findBoxByUser(User user) {
        if(user != null){
            return boxRepository.findBoxByUser(user);

        }
        else{
            return null;
        }
    }


}
