package com.treinamentoJava.emprestimo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoJava.emprestimo.entity.Cliente;
import com.treinamentoJava.emprestimo.entity.Emprestimo;
import com.treinamentoJava.emprestimo.exception.ClienteNaoEncontrado;
import com.treinamentoJava.emprestimo.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}


	
	
	public List<Cliente> retornarTodosOsClientes() {
		return this.clienteRepository.findAll();
	}
	
	
	public Cliente retornaCliente(Long cpf) throws ClienteNaoEncontrado {
		if (this.clienteRepository.existsById(cpf)) {
			return this.clienteRepository.findById(cpf).get();
		}
		 throw new ClienteNaoEncontrado(cpf);
		
	}
	
	
	public List<Emprestimo> retornaClienteEmprestimo(Long cpf) throws ClienteNaoEncontrado {
		if (this.clienteRepository.existsById(cpf)) {
			Cliente retorno = this.clienteRepository.findById(cpf).get();
			return retorno.getEmprestimo();
		}
		 throw new ClienteNaoEncontrado(cpf);
		
	}
	
	
	public Cliente cadastrarCliente(Cliente cliente){
		
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente alterarCliente(Long cpf, @Valid Cliente cliente) throws ClienteNaoEncontrado
	{ 
			if (this.clienteRepository.existsById(cpf)) {
				Cliente clienteASerAlterado = this.clienteRepository.findById(cpf).get();
							
				cliente.setCpf(cpf);
				
				
				
			if (cliente.getNome() == null) {
					cliente.setNome(clienteASerAlterado.getNome());					
			}
				
			if (cliente.getTelefone() == null) {
					cliente.setTelefone(clienteASerAlterado.getTelefone());
			}
			
			if (cliente.getRendimentoMensal() == null) {
				cliente.setRendimentoMensal(clienteASerAlterado.getRendimentoMensal());
			}
			
			if (cliente.getRua() == null) {
				cliente.setRua(clienteASerAlterado.getRua());
			}
			
			if (cliente.getNumero() == null) {
				cliente.setNumero(clienteASerAlterado.getNumero());
			}
			
			if (cliente.getCep() == null) {
				cliente.setCep(clienteASerAlterado.getCep());
			}
				
			
			
				return this.clienteRepository.save(cliente);
			}
			throw new ClienteNaoEncontrado(cpf);	
			
	}
	
	public MensagemDeSucesso deletarCliente(Long cpf) throws ClienteNaoEncontrado {
			
		if (this.clienteRepository.existsById(cpf)) {
			this.clienteRepository.deleteById(cpf);
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Deletado com sucesso");
			return mensagem;
				
		} 
		throw new ClienteNaoEncontrado(cpf);
	}
	
	public void calcularValorEmprestimoTotal(Double valor, Long cpf) throws ClienteNaoEncontrado {
		Cliente cliente = retornaCliente(cpf);
		
		Double valorTotalEmprestimo = cliente.getValorTotalEmprestimo() + valor;
		cliente.setValorTotalEmprestimo(valorTotalEmprestimo);
		this.clienteRepository.save(cliente);
	}


	
		
}
