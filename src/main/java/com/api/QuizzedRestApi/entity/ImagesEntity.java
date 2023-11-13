package com.api.QuizzedRestApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class ImagesEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "image_path")
	private String imagePath;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "ImagesEntity [id=" + id + ", imagePath=" + imagePath + "]";
	}

}
