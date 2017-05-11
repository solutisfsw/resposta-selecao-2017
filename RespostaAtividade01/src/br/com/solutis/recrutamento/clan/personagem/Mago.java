package br.com.solutis.recrutamento.clan.personagem;

import br.com.solutis.recrutamento.clan.Clan;
import br.com.solutis.recrutamento.clan.equipamento.Armadura;
import br.com.solutis.recrutamento.clan.equipamento.Pano;

//magos foram criados durante a fuga!
public class Mago  {

	private int level;
	private Armadura armadura;
	private boolean morto = false;
	
	/**
	 * RESPOSTAS
	 * 
	 * Est� a �nica propriedade p�blica nas classes de personagem. A pr�tica de encapsulamento, pede que uma classe evite ter propriedades p�blicas,
	 * a menos que esta seja realmente a inten��o. Os coment�rios dos m�todos {@link #recebeCura(int)} e {@link #diminuiHp(int)}, desta classe,
	 * indicam que h� um perigo nesta propriedade estar p�blica.
	 * Trocando ela para privado ou protected voc� ir� notar um erro no m�todo {@link Clan#curaGuerreirosFeridos()}. A explica��o da respota continua l�.
	 * 
	 */	
	public int hp = 100;
	
	public Mago() {
		this.armadura = new Pano();
	}

	

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) {
		if (armadura != null) {
			this.armadura = armadura;
		} else {
			System.out.println("Um guerreiro sempre deve ter uma armadura");
		}
	}

	public boolean isMortoVivo(){
		return this.morto && this.hp > 0;
	}

	public boolean isVivo() {
		return !morto ;
	}

	public int getHp() {
		return hp;
	}

	// cura sem ressucitar os mortos
	public void recebeCura(int hp){
		if (isVivo() && this.hp < hp) {			
			this.hp = hp;
		}
	}
	
	//O hp de alguem n�o � algo a ser distribuido por ai, existem regras a serem seguidas.
	public void diminuiHp(int hp) {
		if(hp < this.hp){
			this.hp = hp;
			morto = this.hp <= 0 ;
		}
	}

}
