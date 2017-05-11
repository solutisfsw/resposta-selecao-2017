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
	 * Está a única propriedade pública nas classes de personagem. A prática de encapsulamento, pede que uma classe evite ter propriedades públicas,
	 * a menos que esta seja realmente a intenção. Os comentários dos métodos {@link #recebeCura(int)} e {@link #diminuiHp(int)}, desta classe,
	 * indicam que há um perigo nesta propriedade estar pública.
	 * Trocando ela para privado ou protected você irá notar um erro no método {@link Clan#curaGuerreirosFeridos()}. A explicação da respota continua lá.
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
	
	//O hp de alguem não é algo a ser distribuido por ai, existem regras a serem seguidas.
	public void diminuiHp(int hp) {
		if(hp < this.hp){
			this.hp = hp;
			morto = this.hp <= 0 ;
		}
	}

}
