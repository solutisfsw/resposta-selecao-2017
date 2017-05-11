package br.com.solutis.recrutamento.clan.personagem;

public class CavaleiroSagrado extends Cavaleiro{

	public CavaleiroSagrado(int nivel, String lema) {
		super(nivel, lema);
	}

	@Override
	public String getProfissao() {
		return "Cavaleiro Sagrado";
	}

}
