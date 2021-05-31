package br.ufg.inf.imobiliaria.ctrl.converter;

import br.ufg.inf.imobiliaria.ctrl.dto.FuncionarioResponse;
import br.ufg.inf.imobiliaria.model.entities.Funcionario;

public class FuncionarioConverter {

	public static FuncionarioResponse toDTO(Funcionario f) {
		var fResp = new FuncionarioResponse();
		fResp.setAtivo(f.getAtivo());
		fResp.setDepartamento(f.getDepartamento());
		fResp.setDtAdimissao(f.getDtAdimissao());
		fResp.setIdFuncionario(f.getIdFuncionario());
		fResp.setSalario(f.getSalario());
		fResp.setUsuario(UsuarioConverter.toDTO(f.getUsuario()));
		return fResp;
	}
}
