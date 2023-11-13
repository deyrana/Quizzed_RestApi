package com.api.QuizzedRestApi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.QuizzedRestApi.dto.CredentialsDto;
import com.api.QuizzedRestApi.entity.CredentialsEntity;
import com.api.QuizzedRestApi.repo.CredentialsRepo;
import com.api.QuizzedRestApi.service.CredentialsService;
import com.api.QuizzedRestApi.util.HashUtil;

@Service
public class CredentialsServiceImpl implements CredentialsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CredentialsServiceImpl.class);
	
	@Autowired
	private CredentialsRepo credentialsRepo;

	@Override
	public boolean validateUser(CredentialsDto credentialsDto) {
		try {
			CredentialsEntity credentialsEntity = credentialsRepo.findByUsername(credentialsDto.getUsername());
			if (credentialsEntity == null)
				return false;
			return HashUtil.check(credentialsDto.getPassword(), credentialsEntity.getPassword());
		} catch (Exception e) {
			LOG.error("Error occured due to - {}", e.getMessage());
		}
		return false;
	}

	@Override
	public boolean checkUsernameExits(String username) {
		try {
			CredentialsEntity credentialsEntity = credentialsRepo.findByUsername(username);
			if(credentialsEntity!=null) {
				LOG.info("Username found");
				return true;
			}
			return false;
		} catch (Exception e) {
			LOG.error("Error occured due to - {}", e.getMessage());
		}
		return true;
	}

}
