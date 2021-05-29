package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiliaria.model.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
}
