package br.ufg.inf.imobiaria.entities;

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

import br.ufg.inf.imobiaria.enums.FormaPagamento;

@Entity
@Table(name = "tb_pagamento_aluguel")
public class PagamentoAluguel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento_aluguel")
	private Integer idPagamentoAluguel;

	@OneToOne
	@JoinColumn(name = "contrato_id")
	private Contrato contrato;

	private Float valorPagamento;

	@Column(name = "data_vencimento")
	private Date dtVencimento;

	@Column(name = "data_pagamento")
	private Date dtPagamento;

	private FormaPagamento formaPagamento;

	public PagamentoAluguel() {
		super();
	}

	public PagamentoAluguel(Integer idPagamentoAluguel, Contrato contrato, Float valorPagamento, Date dtVencimento,
			Date dtPagamento, FormaPagamento formaPagamento) {
		super();
		this.idPagamentoAluguel = idPagamentoAluguel;
		this.contrato = contrato;
		this.valorPagamento = valorPagamento;
		this.dtVencimento = dtVencimento;
		this.dtPagamento = dtPagamento;
		this.formaPagamento = formaPagamento;
	}

	public Integer getIdPagamentoAluguel() {
		return idPagamentoAluguel;
	}

	public void setIdPagamentoAluguel(Integer idPagamentoAluguel) {
		this.idPagamentoAluguel = idPagamentoAluguel;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Float getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	@Override
	public String toString() {
		return "PagamentoAluguel [idPagamentoAluguel=" + idPagamentoAluguel + ", contrato=" + contrato
				+ ", valorPagamento=" + valorPagamento + ", dtVencimento=" + dtVencimento + ", dtPagamento="
				+ dtPagamento + ", formaPagamento=" + formaPagamento + "]";
	}

}
