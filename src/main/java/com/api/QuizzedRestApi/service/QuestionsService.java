package com.api.QuizzedRestApi.service;

import java.util.List;

import com.api.QuizzedRestApi.entity.QuestionsEntity;

public interface QuestionsService {

	public List<QuestionsEntity> getAllQuestions();
	public List<QuestionsEntity> getQuestions(List<Integer> qIds);
}
