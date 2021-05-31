package br.ufg.inf.imobiliaria.business;

import br.ufg.inf.imobiliaria.model.entities.Funcionario;
import br.ufg.inf.imobiliaria.model.repositories.FuncionarioRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionarioBusiness {

	private final FuncionarioRepository funcionarioRepository;
	
	public FuncionarioBusiness(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public List<Funcionario> list(Pageable pageable) {
		return funcionarioRepository.list(pageable);
	}
	
	public Funcionario getById(Integer id) {
		funcionarioRepository.getById(id);
		return null;
	}
	
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario update(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario delete(Funcionario funcionario) {
		funcionarioRepository.delete(funcionario);
		return funcionario;
	}
}
