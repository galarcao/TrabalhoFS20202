package br.ufg.inf.imobiliaria.model.enums;

public enum StatusImovel {
	DESOCUPADO(0, "Desocupado"),
	OCUPADO(1, "Ocupado"),
	MANUTENCAO(2, "Manutenção"),
	DESATIVADO(3, "Desativado"),
	RESERVADO(4, "Reservado");
		
	private int id;
	private String value;
	
	StatusImovel(int id, String value) {
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
	
	public static StatusImovel get(int id) {
		StatusImovel si = null;
		for(StatusImovel tis : StatusImovel.values()) {
			if(tis.getId() == id) {
				si = tis;
				break;
			}
		}
		return si;
	}
}
