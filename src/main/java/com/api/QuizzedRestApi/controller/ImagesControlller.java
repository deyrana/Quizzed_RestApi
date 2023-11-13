package com.api.QuizzedRestApi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.QuizzedRestApi.entity.ImagesEntity;
import com.api.QuizzedRestApi.service.ImagesService;

@RestController
@CrossOrigin
@RequestMapping("/images")
public class ImagesControlller {
	
	private static final Logger LOG = LoggerFactory.getLogger(ImagesControlller.class);
	@Autowired
	private ImagesService imagesService;
	
	@GetMapping
	@ResponseBody
	@Cacheable(cacheNames = "images")
	public ResponseEntity<List<ImagesEntity>> getAllImages() {
		try {
			return ResponseEntity.ok().body(imagesService.fetchAllImages());
		} catch (Exception e) {
			LOG.error("Error occurred due to - {}", e.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}

}
