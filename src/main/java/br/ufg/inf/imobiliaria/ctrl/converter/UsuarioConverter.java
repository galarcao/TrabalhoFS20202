package br.ufg.inf.imobiliaria.ctrl.converter;

import br.ufg.inf.imobiliaria.ctrl.dto.UsuarioResponse;
import br.ufg.inf.imobiliaria.model.entities.Usuario;

public class UsuarioConverter {

	static UsuarioResponse toDTO(Usuario u) {
		var uResp = new UsuarioResponse();
		uResp.setAtivo(u.getAtivo());
		uResp.setId(u.getIdUsuario());
		uResp.setPessoa(PessoaConverter.toDTO(u.getPessoa()));
		return uResp;
	}
}
