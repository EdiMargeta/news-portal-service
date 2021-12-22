package com.newsPortal.newsPortal.service.user;

//import com.faks.faks.model.command.base.ApiBasePageCommand;
import com.newsPortal.newsPortal.model.command.user.DeleteUserCommand;
import com.newsPortal.newsPortal.model.command.user.FilterUserCommand;
import com.newsPortal.newsPortal.model.command.user.SaveUserCommand;
import com.newsPortal.newsPortal.model.dto.auth.UserDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBaseDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ErrorInfo;
import com.newsPortal.newsPortal.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public ApiBaseDTO<UserDTO> saveUser(SaveUserCommand command) {
        return ApiBaseDTO.generateSuccessResponse(UserDTO.fromEntity(userRepository.save(command.toEntity())));
    }

    @Transactional
    @Override
    public ApiBaseDTO<UserDTO> filterUser(FilterUserCommand command) {
        return userRepository.findById(command.getId())
                .map(user -> ApiBaseDTO.generateSuccessResponse(UserDTO.fromEntity(user)))
                .orElseGet(() -> ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR));
    }


    @Override
    public Boolean deleteUser(DeleteUserCommand command) {
        userRepository.deleteById(command.getId());
        return true;
    }

}
