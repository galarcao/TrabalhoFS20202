package br.ufg.inf.imobiliaria.ctrl.dto;

import br.ufg.inf.imobiliaria.model.entities.Departamento;
import br.ufg.inf.imobiliaria.model.entities.Usuario;
import java.util.Date;

public class FuncionarioResponse {
	private Integer idFuncionario;
	private Usuario usuario;
	private Float salario;
	private Date dtAdimissao;
	private Departamento departamento;
	private Boolean ativo;
}
