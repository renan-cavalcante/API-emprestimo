package com.treinamentoJava.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoJava.emprestimo.entity.Endereco;
import com.treinamentoJava.emprestimo.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private final EnderecoRepository enderecoRepository;
	
	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public Endereco cadastrarEndereco( Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	
	}

	public List<Endereco> retornarTodosOsEnderecos() {
		return this.enderecoRepository.findAll();

	}
}
