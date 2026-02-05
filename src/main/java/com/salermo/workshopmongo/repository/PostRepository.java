package com.salermo.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.salermo.workshopmongo.domain.Post;

//Repositorio da classe para o banco de dados
@Repository	
public interface PostRepository extends MongoRepository<Post, String>{ //Tenho que por qual a clase e o tipo do id

	//Metodo de busca
	List<Post> findByTitleContainingIgnoreCase(String text);
	//O ignoreCase ignora se é maiuscula ou minuscula
}