package com.treinamentoJava.emprestimo.dto;

import java.util.ArrayList;
import java.util.List;

import com.treinamentoJava.emprestimo.entity.Emprestimo;
import com.treinamentoJava.emprestimo.enums.Relacionamento;

public class EmprestimoDTO {
	private Long id;
	private Double valorInicial;
	private Double valorFinal;
	private Relacionamento relacionamento;
	private int dataInicial;
	private int dataFinal;
	
	
	public EmprestimoDTO() {
	}
	
	public static EmprestimoDTO retornaEmprestimo(Emprestimo emprestimo){
		EmprestimoDTO emprestimoDTO = new EmprestimoDTO(emprestimo.getId(), emprestimo.getRelacionamento(), 
				emprestimo.getValorInicial(),emprestimo.getValorFinal(), emprestimo.getDataInicial(),
				emprestimo.getDataFinal());
		return emprestimoDTO;
	}
	
	
	public static List<EmprestimoDTO> retornaEmprestimo(List<Emprestimo> emprestimos){
		List<EmprestimoDTO> emprestimoDTO = new ArrayList<>();
		
		for(Emprestimo emprestimo : emprestimos) {
			EmprestimoDTO DTO = new EmprestimoDTO(emprestimo.getId(), emprestimo.getRelacionamento(), 
					emprestimo.getValorInicial(),emprestimo.getValorFinal(), emprestimo.getDataInicial(),
					emprestimo.getDataFinal());
			emprestimoDTO.add(DTO);
		}
		return emprestimoDTO;
	}
	
	
	
	public static Emprestimo retornaEmprestimo(EmprestimoDTO emprestimoDTO){
		
		Emprestimo emprestimo = new Emprestimo(emprestimoDTO.getId(), emprestimoDTO.getRelacionamento(), 
				emprestimoDTO.getValorInicial(),emprestimoDTO.getValorFinal(), emprestimoDTO.getDataInicial(),
				emprestimoDTO.getDataFinal());

		return emprestimo;
	}
	
	
	
	


	public EmprestimoDTO( Long id, Relacionamento relacionamento, Double valorInicial, Double valorFinal,
			int dataInicial, int dataFinal) {
		this.id = id;
		this.relacionamento = relacionamento;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Relacionamento getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(Relacionamento relacionamento) {
		this.relacionamento = relacionamento;
	}

	public int getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(int dataInicial) {
		this.dataInicial = dataInicial;
	}

	public int getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(int dataFinal) {
		this.dataFinal = dataFinal;
	}
	

	
	

	
}
