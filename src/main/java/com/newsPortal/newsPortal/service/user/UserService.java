package com.newsPortal.newsPortal.service.user;

import com.newsPortal.newsPortal.model.command.user.DeleteUserCommand;
import com.newsPortal.newsPortal.model.command.user.FilterUserCommand;
import com.newsPortal.newsPortal.model.command.user.SaveUserCommand;
import com.newsPortal.newsPortal.model.dto.auth.UserDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBaseDTO;

public interface UserService {

    ApiBaseDTO<UserDTO> saveUser(SaveUserCommand command);

    ApiBaseDTO<UserDTO> filterUser(FilterUserCommand command);

    Boolean deleteUser(DeleteUserCommand command);

}
