package com.api.QuizzedRestApi.entity;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

import com.api.QuizzedRestApi.dto.AnswerDto;

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
	@Column(name = "image_name")
	private String imageName;
	@Column(name = "pic_byte", length = 900000000)
	private byte[] picByte;
	@Column(name = "image_type")
	private String imageType;
	@Column(name = "created_ts", updatable = false, insertable = false)
	private Timestamp createdTs;
	@Column(name = "last_updated_ts", updatable = false, insertable = false)
	private Timestamp lastUpdatedTs;

	public AnswersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswersEntity(AnswerDto adto) throws IOException {
		super();
		this.correctOption = adto.getCorrectOption();
		this.ansExplaination = adto.getAnsExplaination();
	}

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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
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

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@Override
	public String toString() {
		return "AnswersEntity [ansId=" + ansId + ", qId=" + qId + ", correctOption=" + correctOption
				+ ", ansExplaination=" + ansExplaination + ", imageName=" + imageName + ", picByte="
				+ Arrays.toString(picByte) + ", imageType=" + imageType + ", createdTs=" + createdTs
				+ ", lastUpdatedTs=" + lastUpdatedTs + "]";
	}

}
