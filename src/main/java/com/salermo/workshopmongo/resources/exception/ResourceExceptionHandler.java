package com.salermo.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javassist.tools.rmi.ObjectNotFoundException;

@ControllerAdvice //Serve para indicar que a classe é responsavel de tratar possiveis erros
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class) //Serve para ele identificar que quando ocorrer essa exceção fazer o tratamento abaixo
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		//System.currentTimeMillis() para pegar o instante que ocorre o erro
		HttpStatus status = HttpStatus.NOT_FOUND;
 		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
 		return ResponseEntity.status(status).body(err); //retorno os status e o err
	}

}
