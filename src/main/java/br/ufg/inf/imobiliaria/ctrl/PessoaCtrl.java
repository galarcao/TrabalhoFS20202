package br.ufg.inf.imobiliaria.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.imobiliaria.util.Message;
import br.ufg.inf.imobiliaria.business.PessoaBusiness;
import br.ufg.inf.imobiliaria.ctrl.exception.PessoaException;
import br.ufg.inf.imobiliaria.model.entities.Pessoa;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/pessoas")
public class PessoaCtrl {
	
	@Autowired
	private PessoaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Pessoa> list = business.findAll();
		if (list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0010"));
		}
		return new ResponseEntity<List<Pessoa>>(list, headers, status);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id) throws PessoaException{
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		Pessoa retorno = new Pessoa();
		try {
			retorno = business.findById(id);
		} catch (PessoaException e) {
			//headers.add("message", Message.get(e.getMessage()));
			status = HttpStatus.NO_CONTENT;
		} catch (Exception e) {
			//headers.add("message", Message.get("0002"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Pessoa>(retorno, headers, status);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		try {
			pessoa = business.insert(pessoa);
			//headers.add("message", Message.get("0115"));
		} catch (PessoaException e) {
			status = HttpStatus.BAD_REQUEST;
			//headers.add("message", Message.get(e.getMessage()));
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			//headers.add("message", Message.get("0102"));
		}
		return new ResponseEntity<Pessoa>(pessoa, headers, status);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		try {
			business.delete(id);
			//headers.add("message", Message.get("0116"));
		}catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			//headers.add("message", Message.get("0117"));
		}
		return new ResponseEntity<Void>(null, headers, status);
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			pessoa = business.insert(pessoa);
			//headers.add("message", Message.get("0118"));
		} catch (PessoaException e) {
			status = HttpStatus.BAD_REQUEST;
			//headers.add("message", Message.get(e.getMessage()));			
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			//headers.add("message", Message.get("0106"));	
		}
		return new ResponseEntity<Pessoa>(pessoa, headers, status);
	}
}
