package br.ufg.inf.imobiaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.imobiaria.entities.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Integer>{
	
}
