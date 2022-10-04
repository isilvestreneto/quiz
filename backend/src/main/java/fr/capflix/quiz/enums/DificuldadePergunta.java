package fr.capflix.quiz.enums;

public enum DificuldadePergunta {

	FACIL(1, "Fácil"), MEDIO(2, "Médio"), DIFICIL(3, "Difícil");

	private int cod;
	private String descricao;

	private DificuldadePergunta(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static DificuldadePergunta toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (DificuldadePergunta x : DificuldadePergunta.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
