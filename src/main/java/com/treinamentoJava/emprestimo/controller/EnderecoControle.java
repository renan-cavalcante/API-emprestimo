package com.treinamentoJava.emprestimo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoJava.emprestimo.entity.Endereco;
import com.treinamentoJava.emprestimo.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoControle {

	private EnderecoService enderecoService;
	
	
	@Autowired
	public EnderecoControle(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	public EnderecoControle() {
	}	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco cadastrarEndreco(@Valid @RequestBody Endereco endereco) {
		return this.enderecoService.cadastrarEndereco(endereco);
	}
	
	@GetMapping
	public List<Endereco> retornarTodosOsEnderecos(){
		 List<Endereco> enderecos = this.enderecoService.retornarTodosOsEnderecos();
		 return enderecos;		
	}
	
}
