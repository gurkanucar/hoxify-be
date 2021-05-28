package com.gucarsoft.ws.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gucarsoft.ws.model.user.User;
import com.gucarsoft.ws.service.UserService;
import com.gucarsoft.ws.utils.CurrentUser;
import com.gucarsoft.ws.utils.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger Log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        Log.info(user.toString());
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
    }

    @PostMapping("/login")
    @JsonView(Views.Base.class)
    public ResponseEntity<?> loginUser(@CurrentUser User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    @JsonView(Views.Base.class)
    public List<User> loginUser() {
        return userService.getAllUsers();
    }

}
