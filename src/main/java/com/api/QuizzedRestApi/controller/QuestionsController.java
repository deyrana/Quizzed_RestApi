package com.api.QuizzedRestApi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.QuizzedRestApi.entity.QuestionsEntity;
import com.api.QuizzedRestApi.service.QuestionsService;

@RestController
@CrossOrigin
@RequestMapping("/ques")
public class QuestionsController {

	private static final Logger LOG = LoggerFactory.getLogger(QuestionsController.class);

	@Autowired
	private QuestionsService questionsService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<QuestionsEntity>> getAllQuestions() {
		try {
			List<QuestionsEntity> questionsList = questionsService.getAllQuestions();
			return ResponseEntity.ok().body(questionsList);
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}

		return ResponseEntity.notFound().build();

	}

	@GetMapping(path = "/qids")
	@ResponseBody
	public ResponseEntity<List<QuestionsEntity>> getQuestions(@RequestParam("ids") String ids) {
		try {
			int[] numbers = Arrays.stream(ids.split(",")).mapToInt(Integer::parseInt).toArray();
			List<Integer> qIds = Arrays.stream(numbers).boxed().collect(Collectors.toList());
			List<QuestionsEntity> questionList = questionsService.getQuestions(qIds);
			return ResponseEntity.ok().body(questionList);
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}

		return ResponseEntity.notFound().build();

	}
}
