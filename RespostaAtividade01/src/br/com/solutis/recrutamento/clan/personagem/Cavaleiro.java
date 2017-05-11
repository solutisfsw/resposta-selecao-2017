package br.com.solutis.recrutamento.clan.personagem;

import br.com.solutis.recrutamento.clan.equipamento.Aco;
import br.com.solutis.recrutamento.clan.equipamento.Armadura;

// todo cavaleiro foi um plebeu um dia
public class Cavaleiro  {
	
	protected int level;
	protected Armadura armadura;
	private boolean morto = false;
	private int hp = 100;
	
	public Cavaleiro() {
		this.armadura = new Aco();
	}
	
	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) {
		if(armadura != null){			
			this.armadura = armadura;
		}else{
			System.out.println("Um guerreiro sempre deve ter uma armadura");
		}
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){
		this.level = level;
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

	public void diminuiHp(int hp) {
		if(hp < this.hp){
			this.hp = hp;
			morto = this.hp <= 0 ;
		}
	}

	public boolean isVivo() {
		return !morto;
	}
	
	public boolean isMortoVivo(){
		return this.morto && this.hp > 0;
	}


	
//	public void sofreAtaque(Cavaleiro guerreiro){
//		this.setHp(this.getHp() - (36 - this.getArmadura().getReducaoDano()));
//	}
//	
//	
//	public void sofreAtaque(Mago mago){
//		this.setHp(this.getHp() - (55 - this.getArmadura().getReducaoDano()));
//	}
//	
//	public void sofreAtaque(Arqueiro arqueiro){
//		this.setHp(this.getHp() - this.getArmadura().getReducaoDano()));
//	}

}
