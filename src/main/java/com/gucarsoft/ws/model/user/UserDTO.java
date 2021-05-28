package com.gucarsoft.ws.model.user;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String name;
    private String image;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.name =user.getName();
        this.image = user.getImage();
    }
}
