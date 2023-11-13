package com.api.QuizzedRestApi.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.QuizzedRestApi.entity.AnswersEntity;
import com.api.QuizzedRestApi.service.AnswersService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class AnswersServiceImpl implements AnswersService {

	private static final Logger LOG = LoggerFactory.getLogger(AnswersServiceImpl.class);

//	@Autowired
//	private AnswersRepo answersRepo;

	@Autowired
	private EntityManager em;

	@Override
	public List<AnswersEntity> getAnswers(List<Integer> qIds) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AnswersEntity> cq = cb.createQuery(AnswersEntity.class);

		Root<AnswersEntity> root = cq.from(AnswersEntity.class);
		cq.select(root).where(root.get("qId").in(qIds));

		List<AnswersEntity> result = em.createQuery(cq).getResultList();

		return result;
	}

}
