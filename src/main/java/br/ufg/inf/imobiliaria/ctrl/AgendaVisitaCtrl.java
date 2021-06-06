package br.ufg.inf.imobiliaria.ctrl;

import br.ufg.inf.imobiliaria.util.Message;
import br.ufg.inf.imobiliaria.business.AgendaVisitaBusiness;
//import br.ufg.inf.imobiliaria.ctrl.converter.AgendaVisitaConverter;
import br.ufg.inf.imobiliaria.ctrl.dto.AgendaVisitaResponse;
import br.ufg.inf.imobiliaria.ctrl.exception.AgendaVisitaException;
import br.ufg.inf.imobiliaria.ctrl.exception.PessoaException;
import br.ufg.inf.imobiliaria.model.entities.AgendaVisita;
import br.ufg.inf.imobiliaria.model.entities.Pessoa;
import br.ufg.inf.imobiliaria.model.repositories.AgendaVisitaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/agendaVisita")
public class AgendaVisitaCtrl {
	
	private final AgendaVisitaBusiness agendaVisitaBusiness;
	
	public AgendaVisitaCtrl(AgendaVisitaBusiness agendaVisitaBusiness, AgendaVisitaRepository agendaVisitaRepository) {
		this.agendaVisitaBusiness = agendaVisitaBusiness;
	}
	
	@GetMapping
	public ResponseEntity<List<AgendaVisita>> listAgendaVisitas() {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<AgendaVisita> list = agendaVisitaBusiness.list();
		if(list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0211"));
		}
		return new ResponseEntity<List<AgendaVisita>>(list, headers, status);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AgendaVisita> getAgendaVisita(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		AgendaVisita retorno = new AgendaVisita();
		try {
			retorno = agendaVisitaBusiness.getById(id);
		} catch (AgendaVisitaException e) {
			//headers.add("message", Message.get(e.getMessage()));
			status = HttpStatus.NO_CONTENT;
		} catch (Exception e) {
			//headers.add("message", Message.get("0002"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<AgendaVisita>(retorno, headers, status);
	}
	
	@PostMapping
	public ResponseEntity<AgendaVisita> cadastroAgendaVisita(@RequestBody AgendaVisita agendaVisita){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
	
		try {
			agendaVisita = agendaVisitaBusiness.save(agendaVisita);
			headers.add("message", Message.get("0601"));
		} catch (AgendaVisitaException e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Message.get(e.getMessage()));
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0602"));
		}
	
		return new ResponseEntity<AgendaVisita>(agendaVisita, headers, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarAgendaVisita(@PathVariable Integer id) {
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		try {
			agendaVisitaBusiness.delete(id);
			headers.add("message", Message.get("0116"));
		}catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0117"));
		}
		return new ResponseEntity<Void>(null, headers, status);
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<Void> updateStatus(@RequestBody AgendaVisita agendaVisita) {
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		try {
			AgendaVisita old_agendaVisita = agendaVisitaBusiness.getById(agendaVisita.getIdAgendaVisita());
			if(old_agendaVisita.getAprovado() == agendaVisita.getAprovado()) {
				status = HttpStatus.PRECONDITION_FAILED;
				headers.add("message", Message.get("0163"));
			}else {
				agendaVisitaBusiness.updateStatus(old_agendaVisita, agendaVisita.getAprovado());
				headers.add("message", Message.get("164"));
			}
		}catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0000"));
		}
		return new ResponseEntity<Void>(null, headers, status);
	}
}