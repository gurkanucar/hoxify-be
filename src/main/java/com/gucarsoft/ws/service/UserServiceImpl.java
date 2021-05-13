package com.gucarsoft.ws.service;

import com.gucarsoft.ws.model.User;
import com.gucarsoft.ws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }
}
