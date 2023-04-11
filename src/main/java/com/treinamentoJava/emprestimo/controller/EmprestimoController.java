package com.treinamentoJava.emprestimo.controller;

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

import com.treinamentoJava.emprestimo.dto.EmprestimoDTO;
import com.treinamentoJava.emprestimo.entity.Emprestimo;
import com.treinamentoJava.emprestimo.exception.ClienteNaoEncontrado;
import com.treinamentoJava.emprestimo.service.EmprestimoService;
import com.treinamentoJava.emprestimo.service.MensagemDeSucesso;





@RestController
@RequestMapping("/api/v1/clientes/{cpf}")
public class EmprestimoController {
	

	private EmprestimoService emprestimoService;

	
	@Autowired
	public EmprestimoController(EmprestimoService emprestimoService) {
		this.emprestimoService = emprestimoService;
	}
	
	
	@GetMapping("/emprestimos")
	public List<EmprestimoDTO> retornarTodosOsEmprestimos(@PathVariable Long cpf) throws  ClienteNaoEncontrado{
		List<Emprestimo> emprestimos = this.emprestimoService.retornarTodosOsEmprestimos(cpf);
		List<EmprestimoDTO> emprestimosDTO = EmprestimoDTO.retornaEmprestimo(emprestimos);
		 return emprestimosDTO;		
	}
	
	@GetMapping("emprestimos/{id}")
	public EmprestimoDTO retornarEmprestimo( @PathVariable Long id) throws  ClienteNaoEncontrado{
		Emprestimo emprestimoRecuperado = this.emprestimoService.retornaEmprestimo(id);
		EmprestimoDTO emprestimoRecuperadoDTO = EmprestimoDTO.retornaEmprestimo(emprestimoRecuperado);
		return emprestimoRecuperadoDTO;
		 
	}
	
	
	@PostMapping("/emprestimos")
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDeSucesso cadastrarEmprestimo(@Valid @RequestBody EmprestimoDTO emprestimoDTO, @PathVariable Long cpf) throws ClienteNaoEncontrado  {
		Emprestimo emprestimo = EmprestimoDTO.retornaEmprestimo(emprestimoDTO);
		return this.emprestimoService.cadastrarEmprestimo(emprestimo, cpf);
	}
	
	
	@PutMapping("/emprestimos/{id}")
	public Emprestimo alterarEmprestimo(@PathVariable Long cpf, @Valid @RequestBody Emprestimo emprestimo)  throws  ClienteNaoEncontrado {
		return this.emprestimoService.alterarEmprestimo(cpf, emprestimo);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/emprestimos/{id}") 
	public MensagemDeSucesso deletarEmprestimo(@PathVariable Long cpf) throws ClienteNaoEncontrado{
		return this.emprestimoService.deletarEmprestimo(cpf);
	}
	
	

}
