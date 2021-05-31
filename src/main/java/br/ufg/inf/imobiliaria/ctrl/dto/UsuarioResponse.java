package br.ufg.inf.imobiliaria.ctrl.dto;

public class UsuarioResponse {
	private Integer id;
	private Boolean ativo;
	private PessoaResponse pessoa;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public PessoaResponse getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(PessoaResponse pessoa) {
		this.pessoa = pessoa;
	}
	
}
