package com.treinamentoJava.emprestimo.entity;



/*
 * A API deve permitir cadastrar, apagar e visualizar empréstimos. Cada empréstimo possui 
os seguintes dados obrigatórios: Id, CPFCliente, ValorInicial, ValorFinal, Relacionamento 
(Bronze, Prata ou Ouro), Data inicial e Data final. 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.treinamentoJava.emprestimo.enums.Relacionamento;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	private Cliente CPFCliente;
	
	
	private Double valorInicial;
	private Double valorFinal;
	private Relacionamento relacionamento;
	private String dataFinal;
	private String dataInicio;
	
	
	
	public Emprestimo() {
	}
	
	public Emprestimo(Long id,Relacionamento relacionamento, Double valorInicial, Double valorFinal, String dataInicio,
			 String dataFinal) {
		this.id = id;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.relacionamento = relacionamento;
		
		this.dataFinal = dataFinal;
	}
	
	
	public Cliente getCPFCliente() {
		return CPFCliente;
	}
	public void setCPFCliente( Cliente CPFCliente) {
		this.CPFCliente = CPFCliente;
	}
	public Double getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}
	public Double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(int quantidadeDeEmprestimo) {
		this.valorFinal =  getRelacionamento().calcularValorFinal(getValorInicial(), quantidadeDeEmprestimo);;
	}
	
	
	public Relacionamento getRelacionamento() {
		return relacionamento;
	}
	public void setRelacionamento(Relacionamento relacionamento) {
		this.relacionamento = relacionamento;
	}

	
	public String getDataFinal() {
		
		return dataFinal;

	}
	public void setDataFinal(String dataFinal)  {
		
		this.dataFinal = dataFinal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}


	
	
	

}
