package com.treinamentoJava.emprestimo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamentoJava.emprestimo.entity.Cliente;


public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

}
