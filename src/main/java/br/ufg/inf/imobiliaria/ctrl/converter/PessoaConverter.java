package br.ufg.inf.imobiliaria.ctrl.converter;

import br.ufg.inf.imobiliaria.ctrl.dto.PessoaResponse;
import br.ufg.inf.imobiliaria.model.entities.Pessoa;

public class PessoaConverter {
	
	static PessoaResponse toDTO(Pessoa p) {
		var pResp = new PessoaResponse();
		pResp.setCpf(p.getCpf());
		pResp.setDtNascimento(p.getDtNascimento());
		pResp.setIdPessoa(p.getIdPessoa());
		pResp.setNmPessoa(p.getNmPessoa());
		return pResp;
	}
}
