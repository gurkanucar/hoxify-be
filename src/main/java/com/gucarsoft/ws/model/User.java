package com.gucarsoft.ws.model;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class User extends BaseEntity implements Serializable {
    private String username;
    private String name;
    private String password;

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
