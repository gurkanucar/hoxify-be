package com.gucarsoft.ws.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gucarsoft.ws.error.ApiError;
import com.gucarsoft.ws.model.user.AuthUser;
import com.gucarsoft.ws.model.user.User;
import com.gucarsoft.ws.service.UserService;
import com.gucarsoft.ws.utils.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> loginUser(@RequestHeader(name = "Authorization", required = false) String auth) {

        String base64encoded = auth.split("Basic ")[1];
        String base64decoded = new String(Base64.getDecoder().decode(base64encoded));
        String username = base64decoded.split(":")[0];
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUsername(username));
    }

}
