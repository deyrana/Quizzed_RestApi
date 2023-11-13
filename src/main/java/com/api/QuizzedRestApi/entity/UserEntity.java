package com.api.QuizzedRestApi.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "created_ts", updatable = false, insertable = false)
	private Timestamp createdTs;
	@Column(name = "last_updated_ts", updatable = false, insertable = false)
	private Timestamp lastUpdatedTs;
	@Column(name = "image")
	private String image;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", createdTs=" + createdTs + ", lastUpdatedTs=" + lastUpdatedTs + ", image=" + image + "]";
	}

}
