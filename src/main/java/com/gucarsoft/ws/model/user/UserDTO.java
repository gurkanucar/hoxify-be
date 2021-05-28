package com.gucarsoft.ws.model.user;

import lombok.Data;

@Data
public class UserDTO {
    private String usernam;
    private String name;
    private String image;

    public UserDTO(User user) {
        this.usernam = user.getUsername();
        this.name =user.getName();
        this.image = user.getImage();
    }
}
