package br.com.portoseguro.rbc.remuneracaovariavel.domain.enums;


public enum TipoCalculo {
	EQUIPE_COMERCIAL(1, "Equipe Comercial"),
	ASSESSORIAS(2, "Assessorias"),
	GRATIFICACAO(3, "Gratificação"),
	CAMPANHA(4, "Campanha");
	
	private int cod;
	private String descricao;
	
	private TipoCalculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoCalculo toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCalculo x : TipoCalculo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
