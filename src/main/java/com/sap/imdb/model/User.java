package com.sap.imdb.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(min = 4, max = 15)
	private String username;
	
	@NotNull
	@Size(min = 4, max = 100)
	@Pattern(regexp = "[a-zA-Z ]+")
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	@Size(min = 6, max = 20)
	private String password;
	
	@NotNull
	private boolean admRights;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime lastLoginDate;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getAdmRights() {
		return admRights;
	}
	public void setAdmRights(boolean admRights) {
		this.admRights = admRights;
	}
	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", admRights="
				+ admRights + ", lastLoginDate=" + lastLoginDate + "]";
	}
	
}
