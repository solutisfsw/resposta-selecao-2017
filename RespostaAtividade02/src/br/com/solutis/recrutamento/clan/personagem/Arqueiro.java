package br.com.solutis.recrutamento.clan.personagem;


// arqueiros são livres.. eles não se consideram nobres nem plebeus
public class Arqueiro extends Guerreiro{

	public Arqueiro(int nivel, String lema) {
		super(nivel, lema);
	}

	@Override
	public String getProfissao() {
		return "Arqueiro";
	}

}
