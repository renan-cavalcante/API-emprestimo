package com.treinamentoJava.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmprestimoNaoEncontrado extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmprestimoNaoEncontrado(Long id) {		
		super("O id:" + id + " nao foi encontrado");			
	}

}
