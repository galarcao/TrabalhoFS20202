package br.ufg.inf.imobiaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiaria.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
}
