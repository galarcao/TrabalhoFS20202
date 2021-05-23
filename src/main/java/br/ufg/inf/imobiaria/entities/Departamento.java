package br.ufg.inf.imobiaria.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_departamento")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private Integer idDepartamento;

	@Column(name = "desc_departamento")
	private String dsDepartamento;

	@OneToOne
	@JoinColumn(name = "chefe_id")
	private Funcionario chefe;

	public Departamento() {
		super();
	}

	public Departamento(Integer idDepartamento, String dsDepartamento, Funcionario chefe) {
		super();
		this.idDepartamento = idDepartamento;
		this.dsDepartamento = dsDepartamento;
		this.chefe = chefe;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getDsDepartamento() {
		return dsDepartamento;
	}

	public void setDsDepartamento(String dsDepartamento) {
		this.dsDepartamento = dsDepartamento;
	}

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}

	@Override
	public String toString() {
		return "Departamento [idDepartamento=" + idDepartamento + ", dsDepartamento=" + dsDepartamento + ", chefe="
				+ chefe + "]";
	}

}
