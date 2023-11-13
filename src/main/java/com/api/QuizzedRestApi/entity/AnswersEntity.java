package com.api.QuizzedRestApi.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "answers")
public class AnswersEntity {

	@Id
	@Column(name = "ans_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ansId;
	@Column(name = "q_id")
	private Integer qId;
	@Column(name = "correct_option")
	private String correctOption;
	@Column(name = "ans_explaination")
	private String ansExplaination;
	@Column(name = "image_path")
	private String imagePath;
	@Column(name = "created_ts", updatable = false, insertable = false)
	private Timestamp createdTs;
	@Column(name = "last_updated_ts", updatable = false, insertable = false)
	private Timestamp lastUpdatedTs;

	public Integer getAnsId() {
		return ansId;
	}

	public void setAnsId(Integer ansId) {
		this.ansId = ansId;
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public String getAnsExplaination() {
		return ansExplaination;
	}

	public void setAnsExplaination(String ansExplaination) {
		this.ansExplaination = ansExplaination;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public Timestamp getLastUpdatedTs() {
		return lastUpdatedTs;
	}

	public void setLastUpdatedTs(Timestamp lastUpdatedTs) {
		this.lastUpdatedTs = lastUpdatedTs;
	}

	@Override
	public String toString() {
		return "AnswersEntity [ansId=" + ansId + ", qId=" + qId + ", correctOption=" + correctOption
				+ ", ansExplaination=" + ansExplaination + ", imagePath=" + imagePath + ", createdTs=" + createdTs
				+ ", lastUpdatedTs=" + lastUpdatedTs + "]";
	}

}
