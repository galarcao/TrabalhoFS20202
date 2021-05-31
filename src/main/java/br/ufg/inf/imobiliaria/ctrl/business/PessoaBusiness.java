package br.ufg.inf.imobiliaria.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.imobiliaria.ctrl.exception.PessoaException;
import br.ufg.inf.imobiliaria.model.entities.Pessoa;
import br.ufg.inf.imobiliaria.model.repositories.PessoaRepository;

@Service
public class PessoaBusiness {
	@Autowired
	private PessoaRepository repository;
	
	public Pessoa insert(Pessoa pessoa) throws PessoaException {
		return(repository.save(pessoa));
	}
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public Pessoa findById(Integer id) throws PessoaException {
		Optional<Pessoa> retorno = repository.findById(id);
		if(retorno.isEmpty()) {
			throw new PessoaException("Pessoa não encontrada!");
		}
		return retorno.get();
	}
	
	public Pessoa update(Pessoa pessoa) throws PessoaException {
		Pessoa pessoaUpd = repository.findById(pessoa.getIdPessoa()).get();
		pessoaUpd.setNmPessoa(pessoa.getNmPessoa());
		return repository.save(pessoaUpd);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
