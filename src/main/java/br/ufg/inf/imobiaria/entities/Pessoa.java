package br.ufg.inf.imobiaria.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa")
	private Integer idPessoa;
	
	@Column(name="nome_pessoa")
	private String nmPessoa;
	
	
	private String cpf;
	
	@Column(name="data_nascimento")
	private Date dtNascimento;

	public Pessoa() {
		super();
	}

	public Pessoa(Integer idPessoa, String nmPessoa, String cpf, Date dtNascimento) {
		this.idPessoa = idPessoa;
		this.nmPessoa = nmPessoa;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
	}
	
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
	
	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nmPessoa=" + nmPessoa + ", cpf=" + cpf + ", dtNascimento="
				+ dtNascimento + "]";
	}
	
}
