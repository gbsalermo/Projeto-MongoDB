package com.salermo.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

//Classe DTO pros comentarios 
public class CommentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private String text;
	private Date date;
	private AuthorDTO author;
	
	//Construtores
	public CommentDTO() {
		
	}

	public CommentDTO(String text, Date date, AuthorDTO author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}

	//Getters e settes
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	




}
