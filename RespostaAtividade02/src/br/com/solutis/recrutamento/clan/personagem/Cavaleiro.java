package br.com.solutis.recrutamento.clan.personagem;


public class Cavaleiro  extends Guerreiro{

	public Cavaleiro(int nivel, String lema) {
		super(nivel, lema);
	}

	@Override
	public String getProfissao() {
		return "Cavaleiro";
	}
	
	
}
