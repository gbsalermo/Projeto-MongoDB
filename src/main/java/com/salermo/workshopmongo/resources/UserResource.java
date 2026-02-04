package com.salermo.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salermo.workshopmongo.domain.User;
import com.salermo.workshopmongo.service.UserService;

//Classe Rest

@RestController //RestController instrui o framework a serializar automaticamente os objetos de retorno
@RequestMapping(value="/users") //Defenindo a base da url
public class UserResource {

	@Autowired //Injeção de dependencia
	private UserService service; //Pro controlador Rest acessar o serviço
	
	
	
	//RequestMapping atua como porteiro da aplicação
	@RequestMapping(method=RequestMethod.GET)
	//Posso usar tbm o GetMapping
	public ResponseEntity <List<User>> findAll(){
		
		
		
		List<User> list = service.findAll(); //Busco no banco de dados e guardo a lista
		return ResponseEntity.ok().body(list); //Retorno a lista
		//ResponseEntity.ok() serve para encapsular uma http de sucesso, ou seja, ela confirma que a requisição foi um sucesso
		//.body é o corpo da resposta que será retornado pelo Responseentity
 	}
}
