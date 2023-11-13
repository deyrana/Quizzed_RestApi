package com.api.QuizzedRestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.api.QuizzedRestApi.entity.QuestionsEntity;

@Repository
public interface QuestionsRepo extends JpaRepository<QuestionsEntity, Integer>, JpaSpecificationExecutor<QuestionsEntity> {

}
