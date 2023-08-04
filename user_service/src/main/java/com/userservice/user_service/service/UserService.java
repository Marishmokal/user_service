package com.userservice.user_service.service;

import com.userservice.user_service.dto.ResponseDto;
import com.userservice.user_service.model.User;

public interface UserService {

	User saveUser(User user);

	ResponseDto getUser(Long id);

}
