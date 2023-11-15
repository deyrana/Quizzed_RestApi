package com.api.QuizzedRestApi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.QuizzedRestApi.dto.AnswerDto;
import com.api.QuizzedRestApi.dto.QuestionDto;
import com.api.QuizzedRestApi.entity.AnswersEntity;
import com.api.QuizzedRestApi.entity.QuestionsEntity;
import com.api.QuizzedRestApi.service.AnswersService;
import com.api.QuizzedRestApi.service.QuestionsService;

@RestController
@CrossOrigin
public class QuestionsController {

	private static final Logger LOG = LoggerFactory.getLogger(QuestionsController.class);

	@Autowired
	private QuestionsService questionsService;

	@Autowired
	private AnswersService answersService;

	@GetMapping(path = "/ques")
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

	@GetMapping(path = "/ques/qids")
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

	@PostMapping(path = "/ques/addQues", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> addQuestions(@RequestPart("question") QuestionDto qdto,
			@RequestPart("answer") AnswerDto ansdto, @RequestPart("quesImageFile") MultipartFile qfile,
			@RequestPart("ansImageFile") MultipartFile afile) {
		try {

			QuestionsEntity qe = new QuestionsEntity(qdto);
			if (!qfile.isEmpty()) {
				qe.setImageName(qfile.getOriginalFilename());
				qe.setPicByte(qfile.getBytes());
				qe.setImageType(qfile.getContentType());
			}

			QuestionsEntity result = questionsService.addQuestion(qe);

			AnswersEntity ae = new AnswersEntity(ansdto);
			ae.setqId(result.getqId());
			if (!afile.isEmpty()) {
				ae.setImageName(afile.getOriginalFilename());
				ae.setPicByte(afile.getBytes());
				ae.setImageType(afile.getContentType());
			}
			answersService.addAnswer(ae);

			return ResponseEntity.ok().body(true);
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}
		return ResponseEntity.badRequest().body(false);
	}

}
