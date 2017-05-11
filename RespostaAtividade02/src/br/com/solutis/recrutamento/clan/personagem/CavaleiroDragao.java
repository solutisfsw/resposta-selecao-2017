package br.com.solutis.recrutamento.clan.personagem;

public class CavaleiroDragao extends Cavaleiro {

	public CavaleiroDragao(int nivel, String lema) {
		super(nivel, lema);
	}

	@Override
	public String getProfissao() {
		return "Cavaleiro Dragão";
	}
	
	@Override
	public int vagasOcupadas() {
		return 2;
	}

}
