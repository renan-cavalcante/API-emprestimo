package com.treinamentoJava.emprestimo.enums;



public enum Relacionamento {
	
	BRONZE(1){
		
		@Override
		public Double calcularValorFinal(Double valorInicial,  int quantidadeDeEmprestimos) {
			return valorInicial * 1.80;
		}
		
	},
	
	PRATA(2){
		@Override
		public Double calcularValorFinal(Double valorInicial,  int quantidadeDeEmprestimos) {
			if(valorInicial > 5000) {
				return valorInicial * 1.40;
			}else {
				return valorInicial * 1.60;
			}
			
		}
	},
	
	OURO(3){
		@Override
		public Double calcularValorFinal(Double valorInicial,  int quantidadeDeEmprestimos) {
			if(quantidadeDeEmprestimos < 2) {
				return valorInicial * 1.20;
			}
			return valorInicial * 1.30;
		}
	};
	

	public abstract Double calcularValorFinal(Double valorInicial, int quantidadeDeEmprestimos);
	

	private int code;
	
	private Relacionamento(int code) {
		this.code = code;
	}
	

	public int getCode() {
		return code;
	}
	
	public static Relacionamento valueOf(int code) {
		for (Relacionamento value : Relacionamento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
	
	

}
