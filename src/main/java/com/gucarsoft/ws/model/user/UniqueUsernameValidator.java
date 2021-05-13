package com.gucarsoft.ws.model.user;

import com.gucarsoft.ws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    UserRepository userRepo;

    @Override
    public boolean isValid(String user, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepo.findAllByUsername(user) == null) {
            return true;
        }
        return false;
    }
}
