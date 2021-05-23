package br.ufg.inf.imobiaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiaria.entities.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer>{
	
}
