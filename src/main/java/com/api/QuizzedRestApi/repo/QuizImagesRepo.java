package com.api.QuizzedRestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.QuizzedRestApi.entity.QuizImagesEntity;

@Repository
public interface QuizImagesRepo extends JpaRepository<QuizImagesEntity, Integer> {

}
