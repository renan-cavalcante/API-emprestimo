package com.treinamentoJava.emprestimo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamentoJava.emprestimo.entity.Emprestimo;


public interface EmprestimoRepository  extends JpaRepository<Emprestimo, Long> {

}
