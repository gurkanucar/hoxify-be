package com.gucarsoft.ws.controller;

import com.gucarsoft.ws.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger Log = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public void createUser(@RequestBody String body){
        Log.info(body);
    }


}
