package br.com.solutis.recrutamento.atividade01;

public class Atividade01 {

	
	/**
	 * RESPOSTAS ( Esta resposta est� relacionada a uma explica��o no m�todo <b>enterraMortos</b> da classe Clan)
	 * 
	 * A exce��o lan�ada pelo m�todo enterra mortos � capturada no m�todo main. Voc� pode utiliza-la para descobrir a linha exata
	 * onde o erro ocorreu. Para isso, basta adicionar a instru��o e.printStackTrace(), antes ou ap�s o System.out.println.
	 * 
	 * Voc� ver� uma sa�da do tipo
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
			System.out.println("O cl� est� um caos! Salve-nos!... O imperador foi congelado com a pedra de prote��o da sua casa na m�o");
		}
	}

}
