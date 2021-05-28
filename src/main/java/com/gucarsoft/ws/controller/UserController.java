package com.gucarsoft.ws.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gucarsoft.ws.model.user.User;
import com.gucarsoft.ws.model.user.UserDTO;
import com.gucarsoft.ws.service.user.UserService;
import com.gucarsoft.ws.utils.CurrentUser;
import com.gucarsoft.ws.utils.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

/*    @GetMapping
    @JsonView(Views.Base.class)
    public Page<User> userList(Pageable pageable ) {
        http://localhost:8080/api/user?page=0&size=2
        return userService.getAllUsers(pageable);
    }


    @GetMapping
    public Page<UserProjection> userListWithProjection(Pageable pageable ) {
        return userService.getAllUsersWithProjection(pageable);
    }
*/

    @GetMapping
    public Page<UserDTO> userListWithDTOn(Pageable pageable ) {
        //method reference java8
        return userService.getAllUsers(pageable).map(UserDTO::new);
    }



}
