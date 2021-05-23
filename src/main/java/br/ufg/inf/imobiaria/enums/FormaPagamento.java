package br.ufg.inf.imobiaria.enums;

public enum FormaPagamento {
	DINHEIRO(0, "Dinheiro"), CHEQUE(1, "Chegue"), BOLETO(2, "Boleto"), CARTAOCREDITO(3, "Cartão de Crédito"),
	CARTAODEBITO(4, "Cartão de Débito"), PIX(5, "Pix"), TRANSFERENCIA(6, "Tranferência");

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
