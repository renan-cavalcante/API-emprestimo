package com.treinamentoJava.emprestimo.service;

import com.treinamentoJava.emprestimo.dto.EmprestimoDTO;
import com.treinamentoJava.emprestimo.entity.Emprestimo;

public class MensagemDeSucesso {
	String mensagem;
	Emprestimo emprestimo;
	
	
	
	public MensagemDeSucesso() {
		super();
	}
	

	public String getMensagem() {
		return mensagem;
	}

	public EmprestimoDTO getEmprestimo() {
		EmprestimoDTO emprestimoDTO = EmprestimoDTO.retornaEmprestimo(emprestimo);
		return emprestimoDTO;
	}



	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setMensagem(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}


}
