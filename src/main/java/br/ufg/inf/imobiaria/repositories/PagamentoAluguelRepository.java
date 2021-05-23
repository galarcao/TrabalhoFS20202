package br.ufg.inf.imobiaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiaria.entities.PagamentoAluguel;

public interface PagamentoAluguelRepository extends JpaRepository<PagamentoAluguel, Integer>{
	
}
