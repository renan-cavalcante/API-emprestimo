package com.treinamentoJava.emprestimo.controller;

// excessão para criação de cliente
// endereco como objeto

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoJava.emprestimo.dto.ClienteDTO;
import com.treinamentoJava.emprestimo.entity.Cliente;
import com.treinamentoJava.emprestimo.exception.ClienteNaoEncontrado;
import com.treinamentoJava.emprestimo.service.ClienteService;
import com.treinamentoJava.emprestimo.service.MensagemDeSucesso;





@RestController
@RequestMapping("/api/v1/emprestimo/clientes")
public class ClienteController {

	private ClienteService clienteService;

	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	@GetMapping
	public List<ClienteDTO> retornarTodosOsClientes(){
		
		
		 List<Cliente> clientes = this.clienteService.retornarTodosOsClientes();
		 List<ClienteDTO> clienteDTO = ClienteDTO.retornaCliente(clientes);
		 return clienteDTO;		
	}
	
	@GetMapping("/{cpf}")
	public ClienteDTO retornarCliente(@PathVariable Long cpf) throws ClienteNaoEncontrado{
		Cliente clienteRecuperado = this.clienteService.retornaCliente(cpf);
		ClienteDTO clienteDTO = ClienteDTO.retornaCliente(clienteRecuperado);
		
		return clienteDTO;
		 
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO cadastrarCliente(@Valid @RequestBody Cliente cliente)  {
		ClienteDTO clienteSalvo = ClienteDTO.retornaCliente(this.clienteService.cadastrarCliente(cliente));
		return clienteSalvo;
	}
	
	
	@PutMapping("/{cpf}")
	public ClienteDTO alterarCliente(@PathVariable Long cpf, @Valid @RequestBody ClienteDTO clienteDTO)  throws ClienteNaoEncontrado {
		Cliente cliente = ClienteDTO.retornaCliente(clienteDTO);
		Cliente clienteRetorno = this.clienteService.alterarCliente(cpf, cliente);
		ClienteDTO clienteDTOEnvio = ClienteDTO.retornaCliente(clienteRetorno);
		return clienteDTOEnvio;
		
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{cpf}") 
	public MensagemDeSucesso deletarCliente(@PathVariable Long cpf) throws ClienteNaoEncontrado{
		return this.clienteService.deletarCliente(cpf);
	}


}
