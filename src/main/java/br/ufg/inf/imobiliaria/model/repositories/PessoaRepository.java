package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiliaria.model.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
}
