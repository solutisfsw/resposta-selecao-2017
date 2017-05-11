package br.com.solutis.recrutamento.clan.personagem;


public class Mago extends Guerreiro {

	public Mago(int nivel, String lema) {
		super(nivel, lema);
	}

	@Override
	public String getProfissao() {
		return "Mago";
	}

}
