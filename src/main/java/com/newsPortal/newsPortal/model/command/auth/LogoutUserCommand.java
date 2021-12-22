package com.newsPortal.newsPortal.model.command.auth;

import lombok.Data;

@Data
public class LogoutUserCommand {
    private String username;
    private String jwtToken;
}
