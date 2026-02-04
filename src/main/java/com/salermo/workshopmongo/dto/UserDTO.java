package com.salermo.workshopmongo.dto;

import java.io.Serializable;

import com.salermo.workshopmongo.domain.User;

//Classe DTO, ela serve para carregar dados das entidades de forma simples protegendo os dados que eu não quero que seja exposto como senhas.
public class UserDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;

	public UserDTO() {
		
	}
	//Construtor sobrecarregado
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
