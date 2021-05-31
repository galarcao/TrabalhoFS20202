package br.ufg.inf.imobiliaria.ctrl;

import br.ufg.inf.imobiliaria.business.FuncionarioBusiness;
import br.ufg.inf.imobiliaria.ctrl.converter.FuncionarioConverter;
import br.ufg.inf.imobiliaria.ctrl.dto.FuncionarioResponse;
import br.ufg.inf.imobiliaria.model.entities.Funcionario;
import br.ufg.inf.imobiliaria.model.repositories.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioCtrl {
	
	private final FuncionarioBusiness funcionarioBusiness;
	
	public FuncionarioCtrl(FuncionarioBusiness funcionarioBusiness, FuncionarioRepository funcionarioRepository) {
		this.funcionarioBusiness = funcionarioBusiness;
	}
	
	@GetMapping
	public ResponseEntity<Page<FuncionarioResponse>> listFuncionarios(@RequestBody Pageable pageable) {
		var responsePageable = funcionarioBusiness.list(pageable).map(FuncionarioConverter::toDTO);
		return ResponseEntity.ok(responsePageable);
	}
	
	@GetMapping("/{id}")
	public Optional<FuncionarioResponse> getFuncionario() {
		return null;
	}
	
	@PostMapping
	public Optional<FuncionarioResponse> cadastroFuncionario() {
		
		return null;
	}
	
	@DeleteMapping("/{id}")
	public Optional<FuncionarioResponse> deletarFuncionario() {
		
		return null;
	}
	
	@PatchMapping
	public Optional<FuncionarioResponse> atualizarFuncionario() {
		
		return null;
	}
}