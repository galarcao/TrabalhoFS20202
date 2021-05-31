package br.ufg.inf.imobiliaria.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufg.inf.imobiliaria.model.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
}
