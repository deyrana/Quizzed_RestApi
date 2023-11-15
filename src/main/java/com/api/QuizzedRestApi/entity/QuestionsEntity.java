package com.api.QuizzedRestApi.entity;

import java.io.IOException;
import java.sql.Timestamp;

import com.api.QuizzedRestApi.dto.QuestionDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class QuestionsEntity {

	@Id
	@Column(name = "q_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qId;
	@Column(name = "genre")
	private String genre;
	@Column(name = "ques")
	private String ques;
	@Column(name = "op_a")
	private String optionA;
	@Column(name = "op_b")
	private String optionB;
	@Column(name = "op_c")
	private String optionC;
	@Column(name = "op_d")
	private String optionD;
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

	public QuestionsEntity() {
		super();

	}

	public QuestionsEntity(QuestionDto qdto) throws IOException {
		super();
		this.ques = qdto.getQues();
		this.genre = qdto.getGenre();
		this.optionA = qdto.getOptionA();
		this.optionB = qdto.getOptionB();
		this.optionC = qdto.getOptionC();
		this.optionD = qdto.getOptionD();
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
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
	
	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
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
		return "QuestionsEntity [qId=" + qId + ", genre=" + genre + ", ques=" + ques + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", imageName=" + imageName
				+ ", createdTs=" + createdTs + ", lastUpdatedTs="
				+ lastUpdatedTs + "]";
	}

}
