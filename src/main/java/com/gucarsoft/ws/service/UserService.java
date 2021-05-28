package com.gucarsoft.ws.service;

import com.gucarsoft.ws.model.user.AuthUser;
import com.gucarsoft.ws.model.user.User;

import java.util.List;

public interface UserService {

    User create(User user);
    boolean checkUserIfExists(String name,String password);
    User getUserByUsername(String username);
    List<User> getAllUsers();

}
