package br.com.solutis.recrutamento.atividade01;

public class Atividade01 {

	
	/**
	 * RESPOSTAS ( Esta resposta está relacionada a uma explicação no método <b>enterraMortos</b> da classe Clan)
	 * 
	 * A exceção lançada pelo método enterra mortos é capturada no método main. Você pode utiliza-la para descobrir a linha exata
	 * onde o erro ocorreu. Para isso, basta adicionar a instrução e.printStackTrace(), antes ou após o System.out.println.
	 * 
	 * Você verá uma saída do tipo
	 * 
	 * java.util.NoSuchElementException
	 *	    at java.util.ArrayList$Itr.next(ArrayList.java:854)
	 *		at br.com.solutis.recrutamento.clan.Clan.enterraMortos(Clan.java:164)
	 * 
	 */
	public static void main(String[] args) {
		try {
			ClanPosGuerra clan = new ClanPosGuerra();
			clan.enterraMortos();
			if (!clan.verificaPreparacaoParaBatalha()) {
				System.out.println("Todos os problemas foram resolvidos! Obrigado.");
			}
		} catch (Exception e) {
			System.out.println("O clã está um caos! Salve-nos!... O imperador foi congelado com a pedra de proteção da sua casa na mão");
		}
	}

}
