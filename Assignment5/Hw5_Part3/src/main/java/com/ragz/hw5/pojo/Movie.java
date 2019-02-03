package com.ragz.hw5.pojo;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */

public class Movie {

	private int id;
	private String title;
	private String actor;
	private String actress;
	private String genre;
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
