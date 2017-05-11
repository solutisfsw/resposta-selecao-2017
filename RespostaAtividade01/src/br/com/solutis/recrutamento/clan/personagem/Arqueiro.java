package br.com.solutis.recrutamento.clan.personagem;

import br.com.solutis.recrutamento.clan.equipamento.Armadura;
import br.com.solutis.recrutamento.clan.equipamento.Couro;

// arqueiros são livres.. eles não se consideram nobres nem plebeus
public class Arqueiro {

	private int level;
	private Armadura armadura;

	private int hp = 100;
	private boolean morto = false;
	
	public Arqueiro() {
		this.armadura = new Couro();
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

	
	public float getHp() {
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

	public boolean isVivo() {
		return !morto;
	}

}
