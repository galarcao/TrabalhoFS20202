package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiliaria.model.entities.PagamentoAluguel;

public interface PagamentoAluguelRepository extends JpaRepository<PagamentoAluguel, Integer>{
	
}
