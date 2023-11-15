package com.api.QuizzedRestApi.service;

import java.util.List;

import com.api.QuizzedRestApi.entity.AnswersEntity;

public interface AnswersService {

	public List<AnswersEntity> getAnswers(List<Integer> qIds);
	public AnswersEntity addAnswer(AnswersEntity ae);
}
