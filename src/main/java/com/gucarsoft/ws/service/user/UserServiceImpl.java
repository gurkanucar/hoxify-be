package com.gucarsoft.ws.service.user;

import com.gucarsoft.ws.model.user.User;
import com.gucarsoft.ws.model.user.UserDTO;
import com.gucarsoft.ws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User create(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public boolean checkUserIfExists(String name, String password) {
        User user = userRepo.findAllByUsername(name);
        if(user!=null){
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findAllByUsername(username);
    }



    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        //Pageable _pageable = PageRequest.of(0,4);
        return userRepo.findAll(pageable);
    }

    @Override
    public Page<UserProjection> getAllUsersWithProjection(Pageable pageable) {
        return userRepo.getAllUsersProjection(pageable);
    }



}
