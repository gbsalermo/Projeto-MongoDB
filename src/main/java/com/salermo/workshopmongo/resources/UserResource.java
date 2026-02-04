package com.salermo.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salermo.workshopmongo.domain.User;

//Classe Rest

@RestController //RestController instrui o framework a serializar automaticamente os objetos de retorno
@RequestMapping(value="/users") //Defenindo a base da url
public class UserResource {

	//RequestMapping atua como porteiro da aplicação
	@RequestMapping(method=RequestMethod.GET)
	//Posso usar tbm o GetMapping
	public ResponseEntity <List<User>> findAll(){
		
		User maria = new User("1", "Maria Brown", "maria@gmail.com"); //Instancio um obj usuario
		User alex = new User("2", "Alex Green", "alex@gmail.com"); //Instancio um segundo obj usuario
		List<User> list = new ArrayList<>(); //Instancio a Lista usuario
		list.addAll(Arrays.asList(maria, alex)); //Adiciono os objetos a lista com addALL 
		return ResponseEntity.ok().body(list); //Retorno a lista
		//ResponseEntity.ok() serve para encapsular uma http de sucesso, ou seja, ela confirma que a requisição foi um sucesso
		//.body é o corpo da resposta que será retornado pelo Responseentity
 	}
}
