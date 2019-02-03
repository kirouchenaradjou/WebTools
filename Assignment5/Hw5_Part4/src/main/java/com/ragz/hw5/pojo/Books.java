package com.ragz.hw5.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
@Entity
@Table(name = "books_table")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true, nullable = false)
	private long id;

	@Column(name = "isbn")
	private String isbn;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String authors;

	@Column(name = "price")
	private float price;



	/**
	 * @param id
	 * @param isbn
	 * @param title
	 * @param authors
	 * @param price
	 */
	public Books(String isbn, String title, String authors, float price) {
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
