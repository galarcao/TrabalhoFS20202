package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiliaria.model.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
}
