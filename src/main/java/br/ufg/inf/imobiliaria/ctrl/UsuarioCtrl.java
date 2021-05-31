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

import br.ufg.inf.imobiliaria.ctrl.business.UsuarioBusiness;
import br.ufg.inf.imobiliaria.ctrl.exception.UsuarioException;
import br.ufg.inf.imobiliaria.model.entities.Usuario;
import br.ufg.inf.imobiliaria.util.Message;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/usuarios")
public class UsuarioCtrl {
	
	@Autowired
	private UsuarioBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Usuario> list = business.findAll();
		if (list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			//headers.add("message", Message.get("0010"));
		}
		return new ResponseEntity<List<Usuario>>(list, headers, status);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) throws UsuarioException{
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		Usuario retorno = new Usuario();
		try {
			retorno = business.findById(id);
		} catch (UsuarioException e) {
			//headers.add("message", Message.get(e.getMessage()));
			status = HttpStatus.NO_CONTENT;
		} catch (Exception e) {
			//headers.add("message", Message.get("0002"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Usuario>(retorno, headers, status);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		try {
			usuario = business.insert(usuario);
			//headers.add("message", Message.get("0115"));
		} catch (UsuarioException e) {
			status = HttpStatus.BAD_REQUEST;
			//headers.add("message", Message.get(e.getMessage()));
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			//headers.add("message", Message.get("0102"));
		}
		return new ResponseEntity<Usuario>(usuario, headers, status);
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
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			usuario = business.insert(usuario);
			//headers.add("message", Message.get("0118"));
		} catch (UsuarioException e) {
			status = HttpStatus.BAD_REQUEST;
			//headers.add("message", Message.get(e.getMessage()));			
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			//headers.add("message", Message.get("0106"));	
		}
		return new ResponseEntity<Usuario>(usuario, headers, status);
	}
}
