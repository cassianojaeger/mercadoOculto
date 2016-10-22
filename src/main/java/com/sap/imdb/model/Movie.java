package com.sap.imdb.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
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
	private String id;
	@NotNull
	private String title;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime releaseDate;
	@NotNull
	@Lob
	private String synopsis;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime lenght;
	@NotNull //tentar melhorar e usar um enumeration com dropdown list
	private String genre;
	@NotNull
	@Lob
	private String thumbnailPath;
	@ElementCollection
	private List<Integer> ratings = new ArrayList<Integer>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public LocalDateTime getLenght() {
		return lenght;
	}
	public void setLenght(LocalDateTime lenght) {
		this.lenght = lenght;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	public List<Integer> getRatings() {
		return ratings;
	}
	public void setRatings(List<Integer> ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", synopsis=" + synopsis
				+ ", lenght=" + lenght + ", genre=" + genre + ", thumbnailPath=" + thumbnailPath + ", ratings="
				+ ratings + "]";
	}
	
}
