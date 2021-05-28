package br.ufg.inf.imobiliaria.model.enums;

public enum FormaPagamento {
	NAO_PAGO(0, "Não Pago"), 
	DINHEIRO(1, "Dinheiro"), 
	CHEQUE(2, "Chegue"), 
	BOLETO(3, "Boleto"), 
	CARTAOCREDITO(4, "Cartão de Crédito"),
	CARTAODEBITO(5, "Cartão de Débito"), 
	PIX(6, "Pix"), 
	TRANSFERENCIA(7, "Tranferência");

	private int id;
	private String value;

	FormaPagamento(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static FormaPagamento get(int id) {
		FormaPagamento fp = null;
		for (FormaPagamento vFp : FormaPagamento.values()) {
			if (vFp.getId() == id) {
				fp = vFp;
				break;
			}
		}
		return fp;
	}

}
