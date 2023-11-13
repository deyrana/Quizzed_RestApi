package com.api.QuizzedRestApi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.QuizzedRestApi.dto.UserDto;
import com.api.QuizzedRestApi.entity.CredentialsEntity;
import com.api.QuizzedRestApi.entity.UserEntity;
import com.api.QuizzedRestApi.mapper.UserDtoToEntity;
import com.api.QuizzedRestApi.repo.CredentialsRepo;
import com.api.QuizzedRestApi.repo.UserRepo;
import com.api.QuizzedRestApi.service.UserService;
import com.api.QuizzedRestApi.util.HashUtil;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CredentialsRepo credentialsRepo;
	
	@Override
	public UserEntity saveUserData(UserDto userDto) {
		try {
			UserEntity userEntity = UserDtoToEntity.mapEntity(userDto);

			UserEntity savedEntity = userRepo.saveAndFlush(userEntity);
			// Save in Credentials DB
			CredentialsEntity credentialsEntity = new CredentialsEntity();
			credentialsEntity.setUserId(savedEntity.getUserId());
			credentialsEntity.setUsername(userDto.getUsername());
			credentialsEntity.setPassword(HashUtil.getSaltedHash(userDto.getPassword()));

			credentialsRepo.saveAndFlush(credentialsEntity);

			return savedEntity;
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}

		return null;
	}

	@Override
	public UserEntity getUser(String username) {
		try {
			UserEntity userEntity = userRepo.getUser(username);
			return userEntity;
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}
		return null;
	}

}
