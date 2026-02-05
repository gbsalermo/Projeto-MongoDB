package com.salermo.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salermo.workshopmongo.domain.Post;
import com.salermo.workshopmongo.domain.User;
import com.salermo.workshopmongo.dto.UserDTO;
import com.salermo.workshopmongo.service.PostService;

import javassist.tools.rmi.ObjectNotFoundException;

//Classe Rest

@RestController //RestController instrui o framework a serializar automaticamente os objetos de retorno
@RequestMapping(value="/posts") //Defenindo a base da url
public class PostResource {

	@Autowired //Injeção de dependencia
	private PostService service; //Pro controlador Rest acessar o serviço
	
	//METODO PARA BUSCAR O USUARIO PELO ID
	//ponho um caminho mais especifico, no caso com o id
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	//Uso o PathVariable para informar que esse id tem que casar com o id da url
	public ResponseEntity <Post> findById(@PathVariable String id) throws ObjectNotFoundException{ 
		
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj); 
		
	}
	
}