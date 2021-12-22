package com.newsPortal.newsPortal.service.auth;

import com.newsPortal.newsPortal.model.command.auth.LoginCommand;
import com.newsPortal.newsPortal.model.dto.auth.LoginDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBaseDTO;
import com.newsPortal.newsPortal.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    ApiBaseDTO<LoginDTO> loginUser(LoginCommand loginCommand, HttpServletRequest request);

    LoginDTO getLoggedUserData();

    Boolean logoutUser();

    User getUserFromPrincipal();

}
