package br.ufg.inf.imobiliaria.ctrl;

import java.security.MessageDigestSpi;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.imobiliaria.ctrl.business.ImovelBusiness;
import br.ufg.inf.imobiliaria.ctrl.exception.ImovelException;
import br.ufg.inf.imobiliaria.model.entities.Imovel;
import br.ufg.inf.imobiliaria.util.Message;

@RestController
@RequestMapping(value = "/imoveis")
public class ImovelCtrl {
	@Autowired
	private ImovelBusiness business;
	
	@PostMapping
	public ResponseEntity<Imovel> insert(@RequestBody Imovel imovel){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			imovel = business.insert(imovel);
			headers.add("message", Message.get("0005"));
		}catch (ImovelException e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Message.get(e.getMessage()));
		}catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0006"));
		}
		
		return new ResponseEntity<Imovel>(imovel, headers, status);
	}
	
	@GetMapping(value = "/desocupados")
	public ResponseEntity<List<Imovel>> findByImoveisDesocupados(){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<Imovel> list = business.findByImoveisDesocupados();
		
		if(list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0009"));
		}
		
		return new ResponseEntity<List<Imovel>>(list, headers, status);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			business.delete(id);
			headers.add("message", Message.get("0007"));
		}catch (ImovelException e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Message.get(e.getMessage()));
		}catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0008"));
		}
		
		return new ResponseEntity<Void>(null, headers, status);
	}
}