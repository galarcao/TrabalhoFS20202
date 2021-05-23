package br.ufg.inf.imobiaria.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contrato")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrato")
	private Integer idContrato;

	@Column(name = "desc_departamento")
	private String dsDepartamento;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario inquilino;

	@OneToOne
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;

	@ManyToMany
	@JoinTable(name = "tb_fiador", joinColumns = @JoinColumn(name = "contrato_id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	Set<Pessoa> fiadores;

	@Column(name = "data_contrato_inicio")
	private Date dtContratoInicio;

	private Boolean ativo;

	@Column(name = "valor_aluguel")
	private Float vlAluguel;

	@Column(name = "dia_vencimento")
	private int diaVencimento;

	@Column(name = "desconto_assuidade")
	private Float descontoAssuidade;

	// em meses
	private int prazo;

	public Contrato() {
		super();
	}

	public Contrato(Integer idContrato, String dsDepartamento, Usuario inquilino, Imovel imovel, Set<Pessoa> fiadores,
			Date dtContratoInicio, Boolean ativo, Float vlAluguel, int diaVencimento, Float descontoAssuidade,
			int prazo) {
		super();
		this.idContrato = idContrato;
		this.dsDepartamento = dsDepartamento;
		this.inquilino = inquilino;
		this.imovel = imovel;
		this.fiadores = fiadores;
		this.dtContratoInicio = dtContratoInicio;
		this.ativo = ativo;
		this.vlAluguel = vlAluguel;
		this.diaVencimento = diaVencimento;
		this.descontoAssuidade = descontoAssuidade;
		this.prazo = prazo;
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public String getDsDepartamento() {
		return dsDepartamento;
	}

	public void setDsDepartamento(String dsDepartamento) {
		this.dsDepartamento = dsDepartamento;
	}

	public Usuario getInquilino() {
		return inquilino;
	}

	public void setInquilino(Usuario inquilino) {
		this.inquilino = inquilino;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Set<Pessoa> getFiadores() {
		return fiadores;
	}

	public void setFiadores(Set<Pessoa> fiadores) {
		this.fiadores = fiadores;
	}

	public Date getDtContratoInicio() {
		return dtContratoInicio;
	}

	public void setDtContratoInicio(Date dtContratoInicio) {
		this.dtContratoInicio = dtContratoInicio;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Float getVlAluguel() {
		return vlAluguel;
	}

	public void setVlAluguel(Float vlAluguel) {
		this.vlAluguel = vlAluguel;
	}

	public int getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Float getDescontoAssuidade() {
		return descontoAssuidade;
	}

	public void setDescontoAssuidade(Float descontoAssuidade) {
		this.descontoAssuidade = descontoAssuidade;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	@Override
	public String toString() {
		return "Contrato [idContrato=" + idContrato + ", dsDepartamento=" + dsDepartamento + ", inquilino=" + inquilino
				+ ", imovel=" + imovel + ", fiadores=" + fiadores + ", dtContratoInicio=" + dtContratoInicio
				+ ", ativo=" + ativo + ", vlAluguel=" + vlAluguel + ", diaVencimento=" + diaVencimento
				+ ", descontoAssuidade=" + descontoAssuidade + ", prazo=" + prazo + "]";
	}

}
