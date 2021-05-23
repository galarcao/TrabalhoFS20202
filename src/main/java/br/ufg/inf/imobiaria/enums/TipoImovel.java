package br.ufg.inf.imobiaria.enums;

public enum TipoImovel {
	APARTAMENTO(0, "Apartamento"),
	CASA(1, "Casa"),
	RURAL(2, "Rural"),
	TERRENO_lOTE(3, "Lote ou Terreno"),
	SALA_COMERCIAL(4, "Sala Comercial");
		
	private int id;
	private String value;
	
	TipoImovel(int id, String value) {
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
	
	public static TipoImovel get(int id) {
		TipoImovel res = null;
		for(TipoImovel ti : TipoImovel.values()) {
			if(ti.getId() == id) {
				res = ti;
				break;
			}
		}
		return res;
	}
}
