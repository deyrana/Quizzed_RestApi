package com.api.QuizzedRestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.api.QuizzedRestApi.entity.AnswersEntity;

@Repository
public interface AnswersRepo extends JpaRepository<AnswersEntity, Integer>, JpaSpecificationExecutor<AnswersEntity> {

}
