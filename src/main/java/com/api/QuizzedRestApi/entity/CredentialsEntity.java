package com.api.QuizzedRestApi.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "credentials")
public class CredentialsEntity {

	@Id
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "created_ts", insertable = false, updatable = false)
	private Timestamp createdts;
	@Column(name = "last_updated_ts", insertable = false, updatable = false)
	private Timestamp lastUpdatedTs;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedts() {
		return createdts;
	}

	public void setCreatedts(Timestamp createdts) {
		this.createdts = createdts;
	}

	public Timestamp getLastUpdatedTs() {
		return lastUpdatedTs;
	}

	public void setLastUpdatedTs(Timestamp lastUpdatedTs) {
		this.lastUpdatedTs = lastUpdatedTs;
	}

	@Override
	public String toString() {
		return "CredentialsEntity [userId=" + userId + ", username=" + username + ", password=" + password
				+ ", createdts=" + createdts + ", lastUpdatedTs=" + lastUpdatedTs + "]";
	}

}
