package br.ufg.inf.imobiliaria.ctrl.dto;

import br.ufg.inf.imobiliaria.model.entities.Departamento;
import java.util.Date;

public class FuncionarioResponse {
	private Integer idFuncionario;
	private UsuarioResponse usuario;
	private Float salario;
	private Date dtAdimissao;
	private Departamento departamento;
	private Boolean ativo;
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public UsuarioResponse getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioResponse usuario) {
		this.usuario = usuario;
	}
	
	public Float getSalario() {
		return salario;
	}
	
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	public Date getDtAdimissao() {
		return dtAdimissao;
	}
	
	public void setDtAdimissao(Date dtAdimissao) {
		this.dtAdimissao = dtAdimissao;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
