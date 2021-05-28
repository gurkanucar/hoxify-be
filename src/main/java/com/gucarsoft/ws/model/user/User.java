package com.gucarsoft.ws.model.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.gucarsoft.ws.model.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
public class User extends BaseEntity implements Serializable, UserDetails {

    @UniqueUsername
    @NotNull(message = "{app.validation.username.NotNull.message}")
    @Size(min = 4,max = 25)
    private String username;

    @NotNull
    private String name;

    @NotNull
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;

    private String image;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_USER");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
