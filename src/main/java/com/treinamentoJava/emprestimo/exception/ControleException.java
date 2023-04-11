package com.treinamentoJava.emprestimo.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControleException {

	
	@ExceptionHandler(ClienteNaoEncontrado.class)
	public ResponseEntity<StandardError> ClienteNaoEncontrado(ClienteNaoEncontrado e, HttpServletRequest request) {
		String error = "Recuros não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
