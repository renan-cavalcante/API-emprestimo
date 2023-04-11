package com.treinamentoJava.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontrado extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ClienteNaoEncontrado(Long cpf) {		
		super("O cpf:" + cpf + " nao foi encontrado");			
	}

}
