package br.ufg.inf.imobiliaria.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Integer idFuncionario;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	private Float salario;

	@Column(name = "data_admissao")
	private Date dtAdimissao;

	@OneToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	private Boolean ativo;

	public Funcionario() {
		super();
	}

	public Funcionario(Integer idFuncionario, Usuario usuario, Float salario, Date dtAdimissao,
			Departamento departamento, Boolean ativo) {
		super();
		this.idFuncionario = idFuncionario;
		this.usuario = usuario;
		this.salario = salario;
		this.dtAdimissao = dtAdimissao;
		this.departamento = departamento;
		this.ativo = ativo;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
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

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", usuario=" + usuario + ", salario=" + salario
				+ ", dtAdimissao=" + dtAdimissao + ", departamento=" + departamento + ", ativo=" + ativo + "]";
	}

}
