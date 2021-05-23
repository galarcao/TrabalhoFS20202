package br.ufg.inf.imobiaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiaria.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
}
