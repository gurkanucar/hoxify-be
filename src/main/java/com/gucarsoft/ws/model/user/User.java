package com.gucarsoft.ws.model.user;

import com.gucarsoft.ws.model.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {

    @UniqueUsername
    @NotNull
    @Size(min = 4,max = 25)
    private String username;

    @NotNull
    private String name;

    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;

}
