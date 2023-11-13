package com.api.QuizzedRestApi.mapper;

import java.sql.Date;

import com.api.QuizzedRestApi.dto.UserDto;
import com.api.QuizzedRestApi.entity.UserEntity;

public class UserDtoToEntity {

	public static UserEntity mapEntity(UserDto userDto) {
		UserEntity entity = new UserEntity();
		entity.setName(userDto.getName());
		entity.setEmail(userDto.getEmail());
		entity.setDateOfBirth(userDto.getDob() != null ? Date.valueOf(userDto.getDob()) : null);
		entity.setImage(userDto.getImage());
		return entity;
	}
}
