package com.api.QuizzedRestApi.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.QuizzedRestApi.entity.QuestionsEntity;
import com.api.QuizzedRestApi.repo.QuestionsRepo;
import com.api.QuizzedRestApi.service.QuestionsService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class QuestionsServiceImpl implements QuestionsService {

	private static final Logger LOG = LoggerFactory.getLogger(QuestionsService.class);

	@Autowired
	private QuestionsRepo questionsRepo;
	
	@Autowired
	private EntityManager em;

	@Override
	public List<QuestionsEntity> getAllQuestions() {
		try {
			List<QuestionsEntity> questions = questionsRepo.findAll();
			return questions;
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}
		return null;

	}

	@Override
	public List<QuestionsEntity> getQuestions(List<Integer> qIds) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<QuestionsEntity> cq = cb.createQuery(QuestionsEntity.class);

			Root<QuestionsEntity> root = cq.from(QuestionsEntity.class);
			cq.select(root).where(root.get("qId").in(qIds));

			List<QuestionsEntity> result = em.createQuery(cq).getResultList();

			return result;
		} catch (Exception e) {
			LOG.error("Error occurred - {}", e.getMessage());
		}
		
		return null;

	}

}
