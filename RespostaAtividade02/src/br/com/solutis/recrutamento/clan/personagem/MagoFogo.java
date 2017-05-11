package br.com.solutis.recrutamento.clan.personagem;

public class MagoFogo extends Mago{

	public MagoFogo(int nivel, String lema) {
		super(nivel, lema);
	}

	@Override
	public String getProfissao() {
		return "Mago de Fogo";
	}
	
	@Override
	public int vagasOcupadas() {
		return 3;
	
	}

}
