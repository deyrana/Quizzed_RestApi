package com.api.QuizzedRestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.QuizzedRestApi.entity.ImagesEntity;

@Repository
public interface ImagesRepo extends JpaRepository<ImagesEntity, Integer> {

}
