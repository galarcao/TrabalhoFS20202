package br.ufg.inf.imobiliaria.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ufg.inf.imobiliaria.model.enums.StatusImovel;
import br.ufg.inf.imobiliaria.model.enums.TipoImovel;

@Entity
@Table(name = "tb_imovel")
public class Imovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imovel")
	private Integer idImovel;

	@Column(name = "tipo_imovel")
	private TipoImovel tipoImovel;

	@Column(name = "status_imovel")
	private StatusImovel statusImovel;

	private String endereco;

	private String complemento;

	private String bairro;

	private String cidade;

	@Column(name = "quantidade_quarto")
	private Integer qtdQuarto;

	@Column(name = "quantidade_vaga")
	private Integer qdtVagas;

	@Column(name = "quantidade_suite")
	private Integer qdtSuite;

	@Column(name = "metragem")
	private Integer metragem;

	public Imovel() {
		super();
	}

	public Imovel(Integer idImovel, TipoImovel tipoImovel, StatusImovel statusImovel, String endereco,
			String complemento, String bairro, String cidade, Integer qtdQuarto, Integer qdtVagas, Integer qdtSuite,
			Integer metragem) {
		super();
		this.idImovel = idImovel;
		this.tipoImovel = tipoImovel;
		this.statusImovel = statusImovel;
		this.endereco = endereco;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.qtdQuarto = qtdQuarto;
		this.qdtVagas = qdtVagas;
		this.qdtSuite = qdtSuite;
		this.metragem = metragem;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public TipoImovel getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(TipoImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public StatusImovel getStatusImovel() {
		return statusImovel;
	}

	public void setStatusImovel(StatusImovel statusImovel) {
		this.statusImovel = statusImovel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getQtdQuarto() {
		return qtdQuarto;
	}

	public void setQtdQuarto(Integer qtdQuarto) {
		this.qtdQuarto = qtdQuarto;
	}

	public Integer getQdtVagas() {
		return qdtVagas;
	}

	public void setQdtVagas(Integer qdtVagas) {
		this.qdtVagas = qdtVagas;
	}

	public Integer getQdtSuite() {
		return qdtSuite;
	}

	public void setQdtSuite(Integer qdtSuite) {
		this.qdtSuite = qdtSuite;
	}

	public Integer getMetragem() {
		return metragem;
	}

	public void setMetragem(Integer metragem) {
		this.metragem = metragem;
	}

	@Override
	public String toString() {
		return "Imovel [idImovel=" + idImovel + ", tipoImovel=" + tipoImovel + ", statusImovel=" + statusImovel
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade="
				+ cidade + ", qtdQuarto=" + qtdQuarto + ", qdtVagas=" + qdtVagas + ", qdtSuite=" + qdtSuite
				+ ", metragem=" + metragem + "]";
	}

}
