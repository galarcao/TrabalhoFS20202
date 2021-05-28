package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiliaria.model.entities.AgendaVisita;

public interface AgendaVisitaRepository extends JpaRepository<AgendaVisita, Integer>{
	
}
