package com.api.QuizzedRestApi.service;

import java.util.List;

import com.api.QuizzedRestApi.entity.QuestionsEntity;
import com.api.QuizzedRestApi.entity.QuizImagesEntity;

public interface QuestionsService {

	public List<QuestionsEntity> getAllQuestions();

	public List<QuestionsEntity> getQuestions(List<Integer> qIds);

	public QuizImagesEntity saveQuizImage(QuizImagesEntity qie);

	public QuestionsEntity addQuestion(QuestionsEntity qe);

	public List<QuestionsEntity> getQuestionsConfig(String genre, String totalQues);

}
