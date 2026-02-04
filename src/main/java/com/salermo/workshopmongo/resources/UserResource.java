package com.salermo.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salermo.workshopmongo.domain.User;
import com.salermo.workshopmongo.dto.UserDTO;
import com.salermo.workshopmongo.service.UserService;


import javassist.tools.rmi.ObjectNotFoundException;

//Classe Rest

@RestController //RestController instrui o framework a serializar automaticamente os objetos de retorno
@RequestMapping(value="/users") //Defenindo a base da url
public class UserResource {

	@Autowired //Injeção de dependencia
	private UserService service; //Pro controlador Rest acessar o serviço
	
	
	
	//RequestMapping atua como porteiro da aplicação
	@RequestMapping(method=RequestMethod.GET)
	//Posso usar tbm o GetMapping
	public ResponseEntity <List<UserDTO>> findAll(){ //Agora minha lista vai ser do UserDTO
		List<User> list = service.findAll(); //Busco no banco de dados e guardo a lista
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //aplico uma expressão lambda para converter a lista
		return ResponseEntity.ok().body(listDto); //Retorno a lista
		//ResponseEntity.ok() serve para encapsular uma http de sucesso, ou seja, ela confirma que a requisição foi um sucesso
		//.body é o corpo da resposta que será retornado pelo Responseentity
 	}
	//ponho um caminho mais especifico, no caso com o id
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	//Uso o PathVariable para informar que esse id tem que casar com o id da url
	public ResponseEntity <UserDTO> findById(@PathVariable String id) throws ObjectNotFoundException{ 
		
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj)); 
		
	}
	@RequestMapping( method = RequestMethod.POST)
	
	public ResponseEntity <Void> insert(@RequestBody UserDTO objDto){ 
		
		User obj = service.fromDTO(objDto);
		obj = service.inset(obj);
		//Cabeçalho com o url
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
}
