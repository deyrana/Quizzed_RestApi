package com.api.QuizzedRestApi.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz_images")
public class QuizImagesEntity {

	@Id
	@Column(name = "pic_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer picId;
	@Column(name = "name")
	private String name;
	@Column(name = "pic_byte", length = 50000000)
	private byte[] picByte;

	public QuizImagesEntity() {
		super();
	}

	public QuizImagesEntity(String name, byte[] picByte) {
		super();
		this.name = name;
		this.picByte = picByte;
	}

	public long getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "ImageEntity [picId=" + picId + ", name=" + name + ", picByte=" + Arrays.toString(picByte) + "]";
	}

}
