package br.ufg.inf.imobiliaria.ctrl.business;

import java.util.List;
import java.util.Optional;

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
	
	public List<Imovel> findAll() {
		return(repository.findAll());
	}
	
	public Imovel findById(Integer id) throws ImovelException{
		Optional<Imovel> retorno = repository.findById(id);
		if (retorno.isEmpty()) {
			throw new ImovelException("0109");
		}
		return(repository.getById(id));
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
	
	public Imovel update(Imovel imovel) throws ImovelException {
		Imovel imovelUpdate = repository.findById(imovel.getIdImovel()).get();
		
		if (this.atualizavel(imovel)){
			this.validaImovel(imovel);
			
			imovelUpdate.setBairro(imovel.getBairro());
			imovelUpdate.setCidade(imovel.getCidade());
			imovelUpdate.setComplemento(imovel.getComplemento());
			imovelUpdate.setEndereco(imovel.getEndereco());
			imovelUpdate.setMetragem(imovel.getMetragem());
			imovelUpdate.setQdtSuite(imovel.getQdtSuite());
			imovelUpdate.setQdtVagas(imovel.getQdtVagas());
			imovelUpdate.setQtdQuarto(imovel.getQtdQuarto());
			imovelUpdate.setStatusImovel(imovel.getStatusImovel());
			imovelUpdate.setTipoImovel(imovel.getTipoImovel());
			
		}
		return (repository.save(imovelUpdate));
	}
	
	private boolean atualizavel(Imovel imovel) {
		if (imovel.getStatusImovel().equals(StatusImovel.DESOCUPADO)){
			return true;
		}else if (imovel.getStatusImovel().equals(StatusImovel.MANUTENCAO){
			return true;
		}else{
			return false;
		}
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
