package com.treinamentoJava.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.treinamentoJava.emprestimo.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}