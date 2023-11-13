package com.api.QuizzedRestApi.service;

import com.api.QuizzedRestApi.dto.UserDto;
import com.api.QuizzedRestApi.entity.UserEntity;

public interface UserService {

	public UserEntity saveUserData(UserDto userDto);
	
	public UserEntity getUser(String username);

}
