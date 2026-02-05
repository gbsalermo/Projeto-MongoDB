package com.salermo.workshopmongo.dto;

import java.io.Serializable;

import com.salermo.workshopmongo.domain.User;

//Classe DTO
public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private String id;
	private String name;
	
	
	//Construtores
	public AuthorDTO() {
		
	}
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	//Getters e setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
