package br.com.portoseguro.rbc.remuneracaovariavel.domain.enums;

public enum TipoAgravo {
	REAIS(1, "R$"),
	PORCENTAGEM(2, "%"),
	QUANTIDADE(3, "Qtd");
	
	private int cod;
	private String descricao;
	
	private TipoAgravo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoAgravo toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoAgravo x : TipoAgravo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	public static TipoAgravo toEnum(String nmAgravo) {
		
		if(nmAgravo != null) {
			for (TipoAgravo x : TipoAgravo.values()) {
				if (nmAgravo.equalsIgnoreCase(x.descricao)) {
					return x;
				}
			}
			return null;
		}
		throw new IllegalArgumentException("Agravo inválido: "  + nmAgravo );
	}
}
