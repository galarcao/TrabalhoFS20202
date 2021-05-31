package br.ufg.inf.imobiliaria.ctrl.dto;

import java.util.Date;

public class PessoaResponse {
	
	private Integer idPessoa;
	private String nmPessoa;
	private String cpf;
	private Date dtNascimento;
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public String getNmPessoa() {
		return nmPessoa;
	}
	
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
}
