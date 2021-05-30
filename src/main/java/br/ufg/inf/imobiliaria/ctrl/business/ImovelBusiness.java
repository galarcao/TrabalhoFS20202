package br.ufg.inf.imobiliaria.ctrl.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.imobiliaria.ctrl.exception.ImovelException;
import br.ufg.inf.imobiliaria.model.entities.AgendaVisita;
import br.ufg.inf.imobiliaria.model.entities.Contrato;
import br.ufg.inf.imobiliaria.model.entities.Imovel;
import br.ufg.inf.imobiliaria.model.enums.StatusImovel;
import br.ufg.inf.imobiliaria.model.repositories.ImovelRepository;

@Service
public class ImovelBusiness {
	@Autowired
	private ImovelRepository repository;
	private StatusImovel statusImovel;
	
	
	public Imovel insert(Imovel imovel) throws ImovelException {
		this.validaImovel(imovel);
		return(repository.save(imovel));
	}
	
	public void validaImovel(Imovel imovel) throws ImovelException{
		if(imovel.getStatusImovel() != statusImovel.DESOCUPADO && imovel.getStatusImovel() != statusImovel.MANUTENCAO) {
			throw new ImovelException("0001");
		}
		
		if(imovel.getBairro() == null || imovel.getCidade() == null || imovel.getEndereco() == null) {
			throw new ImovelException("0002");
		}
	}
	
	public List<Imovel> findByImoveisDesocupados(){
		return(repository.findByImoveisDesocupados());
	}
	
	public Contrato imovelOcupado(Integer id) {
		return(repository.imovelOcupado(id));
	}
	
	public AgendaVisita imovelSerVisitado(Integer id) {
		return(repository.imovelSerVisitado(id));
	}
	
	public void delete(Integer id) throws ImovelException {
		if(imovelOcupado(id) != null) {
			throw new ImovelException("0003");
		}
		
		if(imovelSerVisitado(id) != null) {
			throw new ImovelException("0004");
		}
		
		repository.deleteById(id);
	}
}
