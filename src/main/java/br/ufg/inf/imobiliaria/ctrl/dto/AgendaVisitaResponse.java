package br.ufg.inf.imobiliaria.ctrl.dto;

import br.ufg.inf.imobiliaria.model.entities.Imovel;
import br.ufg.inf.imobiliaria.model.entities.Usuario;

import java.util.Date;

public class AgendaVisitaResponse {
	
	private Integer idAgendaVisita;
	private Usuario usuario;
	private Imovel imovel;
	private Date dtAgendamento;
	private Date dtEmprestimoChave;
	private Date dtDevolucaoChave;
	private Boolean aprovado;
	
	public Integer getIdAgendaVisita() {
		return idAgendaVisita;
	}
	
	public void setIdAgendaVisita(Integer idAgendaVisita) {
		this.idAgendaVisita = idAgendaVisita;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Imovel getImovel() {
		return imovel;
	}
	
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public Date getDtAgendamento() {
		return dtAgendamento;
	}
	
	public void setDtAgendamento(Date dtAgendamento) {
		this.dtAgendamento = dtAgendamento;
	}
	
	public Date getDtEmprestimoChave() {
		return dtEmprestimoChave;
	}
	
	public void setDtEmprestimoChave(Date dtEmprestimoChave) {
		this.dtEmprestimoChave = dtEmprestimoChave;
	}
	
	public Date getDtDevolucaoChave() {
		return dtDevolucaoChave;
	}
	
	public void setDtDevolucaoChave(Date dtDevolucaoChave) {
		this.dtDevolucaoChave = dtDevolucaoChave;
	}
	
	public Boolean getAprovado() {
		return aprovado;
	}
	
	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
	
}
