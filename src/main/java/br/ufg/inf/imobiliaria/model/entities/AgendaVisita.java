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
@Table(name = "tb_agenda_visita")
public class AgendaVisita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agenda_visita")
	private Integer idAgendaVisita;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;

	@Column(name = "data_hora_agendamento")
	private Date dtAgendamento;

	@Column(name = "data_hora_emprestimo_chave")
	private Date dtEmprestimoChave;

	@Column(name = "data_hora_devolucao_chave")
	private Date dtDevolucaoChave;

	private Boolean aprovado;

	public AgendaVisita() {
		super();
	}

	public AgendaVisita(Integer idAgendaVisita, Usuario usuario, Imovel imovel, Date dtAgendamento,
			Date dtEmprestimoChave, Date dtDevolucaoChave, Boolean aprovado) {
		super();
		this.idAgendaVisita = idAgendaVisita;
		this.usuario = usuario;
		this.imovel = imovel;
		this.dtAgendamento = dtAgendamento;
		this.dtEmprestimoChave = dtEmprestimoChave;
		this.dtDevolucaoChave = dtDevolucaoChave;
		this.aprovado = aprovado;
	}

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

	@Override
	public String toString() {
		return "AgendaVisita [idAgendaVisita=" + idAgendaVisita + ", usuario=" + usuario + ", imovel=" + imovel
				+ ", dtAgendamento=" + dtAgendamento + ", dtEmprestimoChave=" + dtEmprestimoChave
				+ ", dtDevolucaoChave=" + dtDevolucaoChave + ", aprovado=" + aprovado + "]";
	}

}
