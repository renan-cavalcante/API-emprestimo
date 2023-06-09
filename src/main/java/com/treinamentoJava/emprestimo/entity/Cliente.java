/*
 * A API deve permitir cadastrar, alterar, visualizar e excluir clientes. Cada cliente possui os 
	seguintes dados obrigatórios: Nome, CPF, Telefone, Endereço (Rua, Número e CEP) e 
	Rendimento mensal. 
*/

package com.treinamentoJava.emprestimo.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente {
	
	@Id
	private Long cpf;
	
	@NotBlank(message = "Nome nao pode ser nulo.")
	private String nome;
	private Long telefone;
	@NotNull(message = "Rendimento nao pode ser nulo.")
	private Double rendimentoMensal;
	private String rua;
	private Integer numero;
	private Long cep;
	
	
	private double valorTotalEmprestimo;
	private int quantidadeDeEmprestimos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "CPFCliente")
	private List<Emprestimo> emprestimo = new ArrayList<>();
	
	public Cliente() {
		
	}


	public Cliente(Long cpf, List<Emprestimo> emprestimo,  String nome, Long telefone , Double rendimentoMensal, String rua,
			Integer numero, Long cep) {
		super();
		this.cpf = cpf;
		this.emprestimo = emprestimo;
		this.nome = nome;
		this.telefone = telefone;
		this.rendimentoMensal = rendimentoMensal;
		this.rua = rua;
		
		this.numero = numero;
		this.cep = cep;
		
	}
	
	public Cliente(Long cpf, String nome,   Long telefone,Double rendimentoMensal, String rua, Integer numero ,  Long cep
			) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.rendimentoMensal = rendimentoMensal;
		
	}



	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
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

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	

	public Double getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
	
	public double getValorTotalEmprestimo() {
		return valorTotalEmprestimo;
	}


	public void setValorTotalEmprestimo(double valorTotalEmprestimo) {
		this.valorTotalEmprestimo = valorTotalEmprestimo;
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
	
	public Long getVar(long var) {
		return var;
	}	

	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	

	public int getQuantidadeDeEmprestimos() {
		return quantidadeDeEmprestimos;
	}


	public void setQuantidadeDeEmprestimos(int quantidadeDeEmprestimos) {
		this.quantidadeDeEmprestimos = quantidadeDeEmprestimos;
	}
	
	public void setQuantidadeDeEmprestimos() {
		this.quantidadeDeEmprestimos = this.quantidadeDeEmprestimos +1;
	}


	





	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}




	
}
