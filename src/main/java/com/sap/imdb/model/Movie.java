package com.sap.imdb.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String title;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime releaseDate;
	@NotNull
	@Column(length = 2048)
	private String synopsis;
	@NotNull
	private int length;
	@NotNull //tentar melhorar e usar um enumeration com dropdown list
	@Column(length = 1024)
	private ArrayList<Genre> genre;
	@NotNull
	private String rating;
//	@NotNull
//	@Lob
//	private String thumbnailPath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public ArrayList<Genre> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<Genre> genre) {
		this.genre = genre;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
//	@ElementCollection
//	private List<Rating> ratings = new ArrayList<Rating>();
//	@ElementCollection
//	private List<Comment> comments = new ArrayList<Comment>();
	




}
