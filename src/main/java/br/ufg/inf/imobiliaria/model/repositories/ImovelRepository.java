package br.ufg.inf.imobiliaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufg.inf.imobiliaria.model.entities.AgendaVisita;
import br.ufg.inf.imobiliaria.model.entities.Contrato;
import br.ufg.inf.imobiliaria.model.entities.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Integer>{
	@Query("SELECT  c FROM Contrato c WHERE c.imovel.idImovel = :id")
	public Contrato imovelOcupado(@Param("id") Integer id);
	
	@Query("SELECT av FROM AgendaVisita av WHERE av.imovel.idImovel =:id")
	public AgendaVisita imovelSerVisitado(@Param("id") Integer id);
}
