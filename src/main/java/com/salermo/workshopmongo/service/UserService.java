package com.salermo.workshopmongo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salermo.workshopmongo.domain.User;
import com.salermo.workshopmongo.dto.UserDTO;
import com.salermo.workshopmongo.repository.UserRepository;

import javassist.tools.rmi.ObjectNotFoundException;

//Classe serviço de comunicação com o usuario
@Service
public class UserService {

	
	@Autowired //Injeção de dependencia
	private UserRepository repo; //Serviço acessa repo
	
	public List<User> findAll(){
		return repo.findAll(); //Ele vai retornar todos os objetos no banco de dados, 
	}
	
	public User findById(String id) throws ObjectNotFoundException {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
		//uso lambda e informo com .orElseThrow que caso nulo lançar a exceção
	}
	
	public User inset(User obj) {
		return repo.insert(obj);
	}
	public void delete(String id) throws ObjectNotFoundException {
		findById(id); //só para ele pesquisar primeiro e caso não encontre lançar a exceção
		repo.deleteById(id);
	}
	
	public User update(User obj) throws ObjectNotFoundException {
		  User newObj = repo.findById(obj.getId())
		            .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
		    updateData(newObj, obj);
		    return repo.save(newObj);
	}
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail()); //retorno o id, name e email
	}
}
