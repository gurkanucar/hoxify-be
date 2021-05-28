package com.gucarsoft.ws.service.user;

import com.gucarsoft.ws.model.user.User;

import com.gucarsoft.ws.model.user.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User create(User user);
    boolean checkUserIfExists(String name,String password);
    User getUserByUsername(String username);
    Page<User> getAllUsers(Pageable pageable,User user);
    Page<UserProjection> getAllUsersWithProjection(Pageable pageable);
}
