package com.salermo.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salermo.workshopmongo.domain.Post;
import com.salermo.workshopmongo.resources.util.URL;
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
	//Metodo para pesquisa por titulo
	@RequestMapping(value="/titlesearch", method = RequestMethod.GET)
	//Uso o PathVariable para informar que esse id tem que casar com o id da url
	public ResponseEntity <List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) throws ObjectNotFoundException{ 
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list); 
		
	}
	
	//metodo para a pesquisa geral
	
	@RequestMapping(value="/fullsearch", method = RequestMethod.GET)
	//Uso o PathVariable para informar que esse id tem que casar com o id da url
	public ResponseEntity <List<Post>> fullSearch(
			//Serão 3 parametros nesse caso
			@RequestParam(value="text", defaultValue="") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate) throws ObjectNotFoundException{ 
		//Convertendi
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list); 
		
	}
	
	
}