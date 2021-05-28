package br.ufg.inf.imobiliaria.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.imobiliaria.ctrl.business.ImovelBusiness;
import br.ufg.inf.imobiliaria.ctrl.exception.ImovelException;
import br.ufg.inf.imobiliaria.model.entities.Imovel;

@RestController
@RequestMapping(value = "/imoveis")
public class ImovelCtrl {
	@Autowired
	private ImovelBusiness business;
	
	@PostMapping
	public ResponseEntity<Imovel> insert(@RequestBody Imovel imovel) throws ImovelException{
		imovel = business.insert(imovel);
		return(ResponseEntity.ok().body(imovel));
	}
}
