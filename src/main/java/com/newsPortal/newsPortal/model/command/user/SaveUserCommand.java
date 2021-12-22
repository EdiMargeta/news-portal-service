package com.newsPortal.newsPortal.model.command.user;

import com.newsPortal.newsPortal.model.entity.Role;
import com.newsPortal.newsPortal.model.entity.User;
import lombok.Data;

@Data
public class SaveUserCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private Boolean active;
    private Role userRole;

    //TODO password encoder
    public User toEntity (){
        User user = new User();
        user.setId(this.id);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setActive(this.active);
        user.setRole(this.userRole);

        return user;
    }

}
