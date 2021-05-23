package br.ufg.inf.imobiaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiaria.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
}
