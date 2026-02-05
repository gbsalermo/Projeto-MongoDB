package com.salermo.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salermo.workshopmongo.domain.Post;
import com.salermo.workshopmongo.repository.PostRepository;

import javassist.tools.rmi.ObjectNotFoundException;

//Classe serviço de comunicação com o usuario
@Service
public class PostService {

	
	@Autowired //Injeção de dependencia
	private PostRepository repo; //Serviço acessa repo
	
	
	public Post findById(String id) throws ObjectNotFoundException {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
		//uso lambda e informo com .orElseThrow que caso nulo lançar a exceção
		
	}
	//Adiciono o metodo de Busca chamando do repositorio
	public List<Post> findByTitle(String text){
		
		//return repo.findByTitleContainingIgnoreCase(text);
		//Com Query
		return repo.searchTitle(text);
	}
}