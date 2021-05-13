package com.gucarsoft.ws.config;

import com.gucarsoft.ws.model.user.User;
import com.gucarsoft.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userService.getUserByUsername(s);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
