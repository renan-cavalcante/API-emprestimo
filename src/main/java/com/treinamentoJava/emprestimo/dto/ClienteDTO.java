package com.treinamentoJava.emprestimo.dto;

import java.util.ArrayList;
import java.util.List;

import com.treinamentoJava.emprestimo.entity.Cliente;

public class ClienteDTO {
	private String nome;
	private Long cpf;
	private Long telefone;
	private String rua;
	private String numero;
	private Long cep;
	private Double rendimentoMensal;
	
	public ClienteDTO() {
	}
	
	public static ClienteDTO retornaCliente(Cliente cliente){
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getNome(), cliente.getCpf(), 
				cliente.getTelefone(),cliente.getNumero(), cliente.getRua(), cliente.getCep(), cliente.getRendimentoMensal());
		return clienteDTO;
	}
	
	
	public static List<ClienteDTO> retornaCliente(List<Cliente> clientes){
		List<ClienteDTO> clienteDTO = new ArrayList<>();
		
		for(Cliente cliente : clientes) {
			ClienteDTO DTO = new ClienteDTO(cliente.getNome(), cliente.getCpf(), 
				cliente.getTelefone(),cliente.getNumero(), cliente.getRua(), cliente.getCep(), cliente.getRendimentoMensal());
			clienteDTO.add(DTO);
		}
		return clienteDTO;
	}
	
	
	
	public static Cliente retornaCliente(ClienteDTO clienteDTO){
		
		Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getTelefone(),
				clienteDTO.getCep(),clienteDTO.getNumero(), clienteDTO.getRua(), clienteDTO.getRendimentoMensal());

		return cliente;
	}
	

	public ClienteDTO(String nome, Long cpf, Long telefone, String rua, String numero, Long cep, Double rendimentoMensal) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.rendimentoMensal = rendimentoMensal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Double getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(Double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
	
	

	
}
