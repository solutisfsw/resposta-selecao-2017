package br.com.solutis.recrutamento.clan.personagem;

public class MagoGelo extends Mago {

	public MagoGelo(int nivel, String lema) {
		super(nivel, lema);
	}

	@Override
	public String getProfissao() {
		return "Mago de Gelo";
	}
	
	@Override
	public int vagasOcupadas() {
	
		return 1;
	}

}
