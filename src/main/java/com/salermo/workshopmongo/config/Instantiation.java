package com.salermo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.salermo.workshopmongo.domain.Post;
import com.salermo.workshopmongo.domain.User;
import com.salermo.workshopmongo.dto.AuthorDTO;
import com.salermo.workshopmongo.repository.PostRepository;
import com.salermo.workshopmongo.repository.UserRepository;

//Classe de operação para instanciar a base de dados

@Configuration //Anotação pro spring entender que é uma classe de configuração
public class Instantiation implements CommandLineRunner {

	@Autowired//Injeção de dependencia
	private PostRepository postRepository;
	
	@Autowired//Injeção de dependencia
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//Primeiro limpo o repositorio
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		//Instancio os usuarios
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//Salvo os usuarios
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, Abraços!", new AuthorDTO (maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		//Salvo os posts
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
		
	}
	

}
