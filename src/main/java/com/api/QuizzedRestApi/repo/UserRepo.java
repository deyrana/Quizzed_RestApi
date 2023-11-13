package com.api.QuizzedRestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.QuizzedRestApi.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
	
	@Query("SELECT ue FROM UserEntity ue JOIN CredentialsEntity ce ON ue.userId = ce.userId WHERE ce.username = :username")
	public UserEntity getUser(@Param("username") String username);

}
