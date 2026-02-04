package com.salermo.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.salermo.workshopmongo.domain.User;
import com.salermo.workshopmongo.repository.UserRepository;

//Classe de operação para instanciar a base de dados

@Configuration //Anotação pro spring entender que é uma classe de configuração
public class Instantiation implements CommandLineRunner {

	@Autowired//Injeção de dependencia
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Primeiro limpo o repositorio
		userRepository.deleteAll();
		//Instancio os usuarios
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		//Salvo eles
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
	}
	

}
