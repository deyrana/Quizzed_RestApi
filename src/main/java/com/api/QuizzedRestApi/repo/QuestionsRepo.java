package com.api.QuizzedRestApi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.QuizzedRestApi.entity.QuestionsEntity;

@Repository
public interface QuestionsRepo extends JpaRepository<QuestionsEntity, Integer>, JpaSpecificationExecutor<QuestionsEntity> {

	@Query("SELECT qe FROM QuestionsEntity qe WHERE qe.genre = :genre ORDER BY RAND() LIMIT :totalQues")
	List<QuestionsEntity> getQuestionsConfig(@Param("genre") String genre, @Param("totalQues") String totalQues);

	@Query("SELECT qe FROM QuestionsEntity qe ORDER BY RAND() LIMIT :totalQues")
	List<QuestionsEntity> getAllGenreQuestions(String totalQues);

}
