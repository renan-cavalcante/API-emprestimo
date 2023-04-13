package com.treinamentoJava.emprestimo.dto;

import java.util.ArrayList;
import java.util.List;

import com.treinamentoJava.emprestimo.entity.Cliente;

public class ClienteDTO {
	private Long cpf;
	private String nome;
	private Long telefone;
	private Double rendimentoMensal;
	private String rua;
	private Integer numero;
	private Long cep;
	
	
	public ClienteDTO() {
	}
	
	public static ClienteDTO retornaCliente(Cliente cliente){
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getCpf(), cliente.getNome(),  
				cliente.getTelefone(), cliente.getRendimentoMensal(), cliente.getRua(), cliente.getNumero(), cliente.getCep());
		return clienteDTO;
	}
	
	
	public static List<ClienteDTO> retornaCliente(List<Cliente> clientes){
		List<ClienteDTO> clienteDTO = new ArrayList<>();
		
		for(Cliente cliente : clientes) {
			ClienteDTO DTO = new ClienteDTO(cliente.getCpf(), cliente.getNome(),  
					cliente.getTelefone(), cliente.getRendimentoMensal(), cliente.getRua(), cliente.getNumero(), cliente.getCep());
			clienteDTO.add(DTO);
		}
		return clienteDTO;
	}
	
	
	
	public static Cliente retornaCliente(ClienteDTO clienteDTO){
		
		Cliente cliente = new Cliente(clienteDTO.getCpf(),  clienteDTO.getNome(),  
				clienteDTO.getTelefone(), clienteDTO.getRendimentoMensal(), clienteDTO.getRua(),
				clienteDTO.getNumero(), clienteDTO.getCep());

		return cliente;
	}
	

	public ClienteDTO(Long cpf, String nome,  Long telefone, Double rendimentoMensal, String rua, Integer numero, Long cep) {
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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
