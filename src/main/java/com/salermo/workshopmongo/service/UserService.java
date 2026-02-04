package com.salermo.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salermo.workshopmongo.domain.User;
import com.salermo.workshopmongo.repository.UserRepository;

//Classe serviço de comunicação com o usuario
@Service
public class UserService {

	
	@Autowired //Injeção de dependencia
	private UserRepository repo; //Serviço acessa repo
	
	public List<User> findAll(){
		return repo.findAll(); //Ele vai retornar todos os objetos no banco de dados, 
	}
}
