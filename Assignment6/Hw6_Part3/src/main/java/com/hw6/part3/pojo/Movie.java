package com.hw6.part3.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Entity
@Table(name = "movies_table")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "actor")
	private String actor;
	
	@Column(name = "actress")
	private String actress;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "year")
	private int year;
	
	
	/**
	 * @param title
	 * @param actor
	 * @param actress
	 * @param genre
	 * @param year
	 */
	public Movie(String title, String actor, String actress, String genre, int year) {
		super();
		this.title = title;
		this.actor = actor;
		this.actress = actress;
		this.genre = genre;
		this.year = year;
	}
	
	public Movie()
	{
		
	}
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
