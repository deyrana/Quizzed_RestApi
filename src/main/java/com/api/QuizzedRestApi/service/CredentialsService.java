package com.api.QuizzedRestApi.service;

import com.api.QuizzedRestApi.dto.CredentialsDto;

public interface CredentialsService {

	public boolean validateUser(CredentialsDto credentialsDto);

	public boolean checkUsernameExits(String username);
}
