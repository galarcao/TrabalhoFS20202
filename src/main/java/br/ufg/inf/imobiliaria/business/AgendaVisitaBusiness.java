package br.ufg.inf.imobiliaria.business;

import br.ufg.inf.imobiliaria.ctrl.exception.AgendaVisitaException;
import br.ufg.inf.imobiliaria.model.entities.AgendaVisita;
import br.ufg.inf.imobiliaria.model.repositories.AgendaVisitaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgendaVisitaBusiness {

	private final AgendaVisitaRepository agendaVisitaRepository;
	
	public AgendaVisitaBusiness(AgendaVisitaRepository agendaVisitaRepository) {
		this.agendaVisitaRepository = agendaVisitaRepository;
	}
	
	public List<AgendaVisita> list() {
		return agendaVisitaRepository.findAll();
	}
	
	public AgendaVisita getById(Integer id) {
		return agendaVisitaRepository.findById(id).orElse(null);
	}
	
	public AgendaVisita save(AgendaVisita agendaVisita) {
		return agendaVisitaRepository.save(agendaVisita);
	}
	
	public AgendaVisita delete(Integer id) {
		agendaVisitaRepository.deleteById(id);
		return null;
	}
	
	public AgendaVisita updateStatus(AgendaVisita old_agendaVisita, boolean aprovado)
	{
		old_agendaVisita.setAprovado(aprovado);
		return agendaVisitaRepository.save(old_agendaVisita);
	}
	
}
