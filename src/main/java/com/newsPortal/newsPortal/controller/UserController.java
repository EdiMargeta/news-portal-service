package com.newsPortal.newsPortal.controller;

import com.newsPortal.newsPortal.model.command.user.DeleteUserCommand;
import com.newsPortal.newsPortal.model.command.user.FilterUserCommand;
import com.newsPortal.newsPortal.model.command.user.SaveUserCommand;
import com.newsPortal.newsPortal.model.dto.auth.UserDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBaseDTO;
import com.newsPortal.newsPortal.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("Save User")
    @RequestMapping("/save")
    public ApiBaseDTO<UserDTO> saveUser(@RequestBody SaveUserCommand command) {
        return userService.saveUser(command);
    }

    @ApiOperation("Filter Users")
    @RequestMapping("/filter")
    public ApiBaseDTO<UserDTO> filterUsers(@RequestBody FilterUserCommand command) {
        return userService.filterUser(command);
    }

    @ApiOperation("Delete User")
    @RequestMapping("/delete")
    public Boolean deleteUser(@RequestBody DeleteUserCommand command) {
        return userService.deleteUser(command);
    }
}
