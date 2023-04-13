package com.treinamentoJava.emprestimo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private String numero;
	private Long cep;
	
	@JsonIgnore
	@OneToOne
	private Cliente dono;

	
	//String rua, String numero, Long cep
	public Endereco() {
		//this.rua = rua;
		//this.numero = numero;
		//this.cep = cep;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	

	
}
