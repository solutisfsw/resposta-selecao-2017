package br.com.solutis.recrutamento.clan.personagem;


// arqueiros s�o livres.. eles n�o se consideram nobres nem plebeus
public class Arqueiro extends Guerreiro{

	public Arqueiro(int nivel, String lema) {
		super(nivel, lema);
	}

	@Override
	public String getProfissao() {
		return "Arqueiro";
	}

}
