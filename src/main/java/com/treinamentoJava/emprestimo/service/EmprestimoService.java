package com.treinamentoJava.emprestimo.service;

/*
 * Visando diminuir a inadimplência, um cliente somente 
poderá ter um valor total de empréstimos equivalente a 10 vezes o seu 
rendimento mensal. Por exemplo, um cliente com rendimento mensal = 10, 
poderá ter até N (vários) empréstimos, porém a soma do ValorInicial desses 
empréstimos não deve ultrapassar o valor de 100 (rendimento mensal * 10).
Essa verificação deve ocorrer sempre que um novo empréstimo for ser 
inserido para determinado cliente e deve considerar a renda do cliente no 
momento do cadastro do empréstimo.
 */

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoJava.emprestimo.entity.Cliente;
import com.treinamentoJava.emprestimo.entity.Emprestimo;
import com.treinamentoJava.emprestimo.exception.ClienteNaoEncontrado;
import com.treinamentoJava.emprestimo.repository.ClienteRepository;
import com.treinamentoJava.emprestimo.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	private final ClienteRepository clienteRepository;
	private final EmprestimoRepository emprestimoRepository;
	

	
	
	@Autowired
	public EmprestimoService(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
		this.emprestimoRepository = emprestimoRepository;
	}
	
	
	// busca o cliente pelo cpf no serviceCliente
	protected Cliente retornarCliente(Long cpf) throws ClienteNaoEncontrado {
		Cliente cliente = retornarClienteService().retornaCliente(cpf);
		return cliente;
	}
	
	protected ClienteService retornarClienteService() {
		ClienteService clienteService = new ClienteService(this.clienteRepository);
		return clienteService;
	}


	
	
	public List<Emprestimo> retornarTodosOsEmprestimos(Long cpf) throws ClienteNaoEncontrado {
		
		return retornarCliente(cpf).getEmprestimo();
	}
	
	public Emprestimo retornaEmprestimo(Long id) throws ClienteNaoEncontrado {
		if (this.emprestimoRepository.existsById(id)) {
			return this.emprestimoRepository.findById(id).get();
		}
		 throw new ClienteNaoEncontrado(id);
		
	}
	
	
	
	public MensagemDeSucesso cadastrarEmprestimo(Emprestimo emprestimo, Long cpf) throws ClienteNaoEncontrado{
		
		MensagemDeSucesso mensagem = new MensagemDeSucesso();
		Cliente cliente = retornarCliente(cpf);
		
		
		if(concederEmprestimo(emprestimo, cpf)) { 
			
			emprestimo.setValorFinal(cliente.getQuantidadeDeEmprestimos()); // seta o valor final do emprestimo 
			
			cliente.setQuantidadeDeEmprestimos(); // adiciona mais um emprestimo no contador de emprestimo
			
			emprestimo.setCPFCliente(cliente); // define o cliente do emprestimo
			
			retornarClienteService().calcularValorEmprestimoTotal(emprestimo.getValorInicial(),cpf); //chama o contador do valor total emprestado para o cliente
			
			mensagem.setMensagem(this.emprestimoRepository.save(emprestimo));
			return mensagem;
		}
		
		mensagem.setMensagem("Emprestimo negado " );
		return mensagem;
	}
	
	
	
	//verifica se cliente pode ter emprestimo, com base no rendimento mensal, o valor solicitado e o quanto tem de emprestimo
	public boolean concederEmprestimo(Emprestimo emprestimo, Long cpf) throws ClienteNaoEncontrado {  
		Cliente cliente = retornarCliente(cpf);
		Double valorInicial = emprestimo.getValorInicial();
		
		Double rendimentoMensal = cliente.getRendimentoMensal();
		Double totalEmprestado = cliente.getValorTotalEmprestimo();
	
		
		if(valorInicial > rendimentoMensal*10) {
			return false;
		}else {
				if(valorInicial + totalEmprestado  > rendimentoMensal*10) {
					return false;			
				}else {
					
					return true;
				
			}
		}
	}




	public Emprestimo alterarEmprestimo(Long id, @Valid Emprestimo emprestimo) throws ClienteNaoEncontrado { 
			
			if (this.emprestimoRepository.existsById(id)) {
				Emprestimo emprestimoASerAlterado = this.emprestimoRepository.findById(id).get();
							
				emprestimo.setId(id);
				
		
				
				
			if (emprestimo.getValorInicial() == null) {
					emprestimo.setValorInicial(emprestimoASerAlterado.getValorInicial());
					
				}
				
			if (emprestimo.getValorInicial() != null) {
				Cliente cliente = retornarCliente(emprestimoASerAlterado.getCPFCliente().getCpf());
				if(concederEmprestimo(emprestimo, cliente.getCep())){
						
					emprestimo.setValorFinal(cliente.getQuantidadeDeEmprestimos());
						
				}
			}
			
			if(emprestimo.getRelacionamento() == null) {
				emprestimo.setRelacionamento(emprestimoASerAlterado.getRelacionamento());
			}
			
			if(emprestimo.getDataInicio() == null) {
				emprestimo.setDataInicio(emprestimoASerAlterado.getDataInicio());
			}
				
				return this.emprestimoRepository.save(emprestimo);
			}
			throw new ClienteNaoEncontrado(id);	
			
	}
	
	public MensagemDeSucesso deletarEmprestimo(Long id) throws ClienteNaoEncontrado {
			
		if (this.emprestimoRepository.existsById(id)) {
			this.emprestimoRepository.deleteById(id);
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Deletado com sucesso");
			return mensagem;
				
		} 
		throw new ClienteNaoEncontrado(id);
	}

	
		
}
