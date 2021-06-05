package br.ufg.inf.imobiliaria.business;

import br.ufg.inf.imobiliaria.ctrl.exception.FuncionarioException;
import br.ufg.inf.imobiliaria.model.entities.Funcionario;
import br.ufg.inf.imobiliaria.model.repositories.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioBusiness {

	private final FuncionarioRepository funcionarioRepository;
	
	public FuncionarioBusiness(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Page<Funcionario> list(Pageable pageable) {
		return funcionarioRepository.findAll(pageable);
	}
	
	public Funcionario getById(Integer id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public Funcionario save(Funcionario funcionario, PageRequest pageRequest) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario delete(Funcionario funcionario) {
		funcionarioRepository.delete(funcionario);
		return funcionario;
	}
}
