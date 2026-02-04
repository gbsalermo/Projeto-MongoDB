package com.salermo.workshopmongo.service.exception;


//Exceção para caso não tenha id
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//sobreponho o construtor basico dela
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}

