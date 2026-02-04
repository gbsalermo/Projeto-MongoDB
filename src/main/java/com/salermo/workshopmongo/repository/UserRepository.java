package com.salermo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.salermo.workshopmongo.domain.User;

//Repositorio da classe para o banco de dados
@Repository	
public interface UserRepository extends MongoRepository<User, String>{ //Tenho que por qual a clase e o tipo do id

}