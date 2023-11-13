package com.api.QuizzedRestApi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.QuizzedRestApi.dto.CredentialsDto;
import com.api.QuizzedRestApi.dto.UserDto;
import com.api.QuizzedRestApi.entity.UserEntity;
import com.api.QuizzedRestApi.service.CredentialsService;
import com.api.QuizzedRestApi.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private CredentialsService credentialsService;

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserDto userDto) {
		try {
			UserEntity entity = null;
			if (credentialsService.checkUsernameExits(userDto.getUsername())) {
				LOG.info("{} username already exists", userDto.getUsername());
				return ResponseEntity.badRequest().body(entity);
			}
			entity = userService.saveUserData(userDto);
			LOG.info("User Entity - {}", entity);
			return ResponseEntity.ok().body(entity);
		} catch (Exception e) {
			LOG.error("Error occurred due to - {}", e.getMessage());
		}
		return null;
	}

	@PostMapping("/validate")
	@ResponseBody
	public ResponseEntity<Boolean> validateUser(@RequestBody String formData) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			CredentialsDto credentialDto = mapper.readValue(formData, new TypeReference<CredentialsDto>() {
			});
			if (credentialsService.checkUsernameExits(credentialDto.getUsername())) {
				return ResponseEntity.ok().body(credentialsService.validateUser(credentialDto));
			} else {
				return ResponseEntity.badRequest().body(false);
			}
		} catch (JsonMappingException e) {
			LOG.error("Error occurred due to - {}", e.getMessage());
		} catch (JsonProcessingException e) {
			LOG.error("Error occurred due to - {}", e.getMessage());
		}
		return null;
	}

	@GetMapping("/user")
	@ResponseBody
	public ResponseEntity<UserEntity> getUser(@RequestParam("username") String username) {
		try {
			UserEntity userEntity = userService.getUser(username);
			if (userEntity == null) {
//				throw new CustomNotFoundException("User not found");
				throw new Exception("User not found");
			}
			return ResponseEntity.ok().body(userEntity);
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}
		return ResponseEntity.notFound().build();
	}

}
