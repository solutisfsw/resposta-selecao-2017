package br.com.solutis.recrutamento.clan.personagem;

public abstract class Guerreiro {
	
	private String lema;
	private int nivel;
	
	public Guerreiro(int nivel, String lema){
		this.nivel = nivel;
		this.lema = lema;
	}
	
	
	public abstract String getProfissao();
	
	public void dizLema(){
		System.out.println(String.format("%s nível %d se apresentando. Meu lema é %s", this.getProfissao(),this.getNivel(),this.getLema()));
	}
	
	public String getLema() {
		return lema;
	}
	public void setLema(String lema) {
		this.lema = lema;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int vagasOcupadas(){
		return 1;
	}

}
