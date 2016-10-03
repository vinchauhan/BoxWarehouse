package com.vchauhan.web;

import com.vchauhan.domain.Box;
import com.vchauhan.domain.User;
import com.vchauhan.repository.BoxRepository;
import com.vchauhan.security.TokenUser;
import com.vchauhan.security.UserDetailsService;
import com.vchauhan.service.BoxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vineet on 9/8/16.
 */

@RestController
public class BoxController {

    Logger log = LoggerFactory.getLogger(BoxController.class);

    @Autowired
    private BoxService boxService;

//    @CrossOrigin(origins = "http://localhost:8100", allowedHeaders="*",allowCredentials="true")
    @RequestMapping(value = "/api/v1/box", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addBox(@RequestBody Box box) {
        log.info("Received a new box {}" + box.getBoxDetails());
        boxService.save(box);
        log.info("Saved a new box{)" + box.getId());
    }

    @RequestMapping(value = "/api/v1/box/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Box getBox(@PathVariable Long id) {
        log.info("Received a new box {}" + id);

       return boxService.findOne(id);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/api/v1/boxes", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Box> getBoxes() {
        log.info("Received a all boxes {}");
        return boxService.findAll();
    }

    @RequestMapping(value = "/api/v1/box", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Box getBoxByActiveUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Received a new box {} by user" + auth.getPrincipal());
        TokenUser activeUser =  (TokenUser) auth.getDetails();
        log.info("Received a new box {} by activeUser" + activeUser.getUser().getId());
        return boxService.findBoxByUser(activeUser.getUser());

    }

}
