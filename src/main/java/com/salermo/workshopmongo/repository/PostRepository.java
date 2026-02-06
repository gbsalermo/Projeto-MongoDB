package com.salermo.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.salermo.workshopmongo.domain.Post;

//Repositorio da classe para o banco de dados
@Repository	
public interface PostRepository extends MongoRepository<Post, String>{ //Tenho que por qual a clase e o tipo do id

	//Metodo de pesquisa com @query
	//O ?0 é por que eu quero o primeiro parametro
	//O i é para ignorar maiusculas e minusculas
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") //referencia do docs.mongodb{ <field>: { $regex: /pattern/, $options: '<options>' } }
	List<Post> searchTitle(String text);
	
	
	//Metodo de busca
	List<Post> findByTitleContainingIgnoreCase(String text);
	//O ignoreCase ignora se é maiuscula ou minuscula
	
	//Metodo de busca geral
	//O $and é uuma condição, nesse caso pra data minima e data maxima
	//O $gte é para a comparação de maior ou igual
	//$lte é para a comparação de menor ou igual
	//Uso o ?1 para pegar o primeiro parametro, no caso, o minDate 
	@Query("{ $and: [ "
		     + "{date: {$gte: ?1}}, "
		     + "{date: {$lte: ?2}}, "
		     + "{ $or: ["
		     + "  {'title': { $regex: ?0, $options: 'i' }}, "
		     + "  {'body': { $regex: ?0, $options: 'i' }}, "
		     + "  {'comments.text': { $regex: ?0, $options: 'i' }}"
		     + "]}]}")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}