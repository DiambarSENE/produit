package com.example.demo.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ProduitNotFoundException(String message) {
        super(message);
    }
}

