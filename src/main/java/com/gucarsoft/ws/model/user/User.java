package com.gucarsoft.ws.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.gucarsoft.ws.model.BaseEntity;
import com.gucarsoft.ws.utils.Views;
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
    @NotNull(message = "{app.validation.username.NotNull.message}")
    @Size(min = 4,max = 25)
    @JsonView(Views.Base.class)
    private String username;

    @NotNull
    @JsonView(Views.Base.class)
    private String name;

    @NotNull
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;

    @JsonView(Views.Base.class)
    private String image;

}
