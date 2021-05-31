package br.ufg.inf.imobiliaria.ctrl;


import br.ufg.inf.imobiliaria.business.FuncionarioBusiness;
import br.ufg.inf.imobiliaria.ctrl.dto.FuncionarioResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioCtrl {
	
	private final FuncionarioBusiness funcionarioBusiness;
	
	public FuncionarioCtrl(FuncionarioBusiness funcionarioBusiness) {
		this.funcionarioBusiness = funcionarioBusiness;
	}
	
	@GetMapping
	public Optional<List<FuncionarioResponse>> listFuncionarios() {
		
		return null;
	}
	
	@GetMapping("/{id}")
	public Optional<FuncionarioResponse> getFuncionario() {
		System.out.println();
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