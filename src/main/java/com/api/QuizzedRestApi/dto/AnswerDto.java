package com.api.QuizzedRestApi.dto;

public class AnswerDto {

	private String correctOption;
	private String ansExplaination;

	public AnswerDto(String correctOption, String ansExplaination) {
		super();
		this.correctOption = correctOption;
		this.ansExplaination = ansExplaination;
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

	@Override
	public String toString() {
		return "AnswerDto [correctOption=" + correctOption + ", ansExplaination=" + ansExplaination + "]";
	}

}
