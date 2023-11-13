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

import com.api.QuizzedRestApi.entity.AnswersEntity;
import com.api.QuizzedRestApi.service.AnswersService;

@RestController
@CrossOrigin
@RequestMapping("/ans")
public class AnswersController {

	private static final Logger LOG = LoggerFactory.getLogger(AnswersController.class);

	@Autowired
	private AnswersService answersService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<AnswersEntity>> getAnswers(@RequestParam("ques") String ques) {
		try {
			LOG.info("Qids list - {}", ques);
			int[] numbers = Arrays.stream(ques.split(",")).mapToInt(Integer::parseInt).toArray();
			List<Integer> qIds = Arrays.stream(numbers).boxed().collect(Collectors.toList());
			List<AnswersEntity> answersList = answersService.getAnswers(qIds);
			LOG.info("AnswersList - {}", answersList);
			return ResponseEntity.ok().body(answersList);
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}

		return ResponseEntity.notFound().build();

	}

}
