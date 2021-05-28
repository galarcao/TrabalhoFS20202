package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiliaria.model.entities.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer>{
	
}
