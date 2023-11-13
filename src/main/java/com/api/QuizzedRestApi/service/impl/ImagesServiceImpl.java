package com.api.QuizzedRestApi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.QuizzedRestApi.entity.ImagesEntity;
import com.api.QuizzedRestApi.repo.ImagesRepo;
import com.api.QuizzedRestApi.service.ImagesService;

@Service
public class ImagesServiceImpl implements ImagesService {

	@Autowired
	private ImagesRepo imagesRepo;

	@Override
	public List<ImagesEntity> fetchAllImages() {
		return imagesRepo.findAll();
	}
}
