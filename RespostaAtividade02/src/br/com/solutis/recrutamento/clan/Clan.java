package br.com.solutis.recrutamento.clan;

import java.util.ArrayList;
import java.util.List;

import br.com.solutis.recrutamento.clan.personagem.Arqueiro;
import br.com.solutis.recrutamento.clan.personagem.Cavaleiro;
import br.com.solutis.recrutamento.clan.personagem.Guerreiro;
import br.com.solutis.recrutamento.clan.personagem.Mago;

public class Clan {
	
	private List<Guerreiro> guerreiros;
	
	private int vagas = 0;
	private int minNivel = 0;
	
	/**
	 * Construtor do cl� que recebe o n�mero de vagas dispon�veis e  o n�vel m�nimo
	 * @param minLevel
	 * @param vagas
	 */
	public Clan(int minLevel, int vagas) {
		this.vagas = vagas;
		this.minNivel = minLevel;
		guerreiros = new ArrayList<>();
	}

	private boolean validaGuerreiro(Guerreiro guerreiro){
		if(guerreiro.getNivel() < this.minNivel){
			System.out.println("Inscrito n�o tem n�vel suficiente para entrar no cl�"); // Sa�da esperada para quando o guerreiro n�o tem n�vel para entrar no cl�
			return false;
		}
		if(vagas - guerreiro.vagasOcupadas() < 0){
			System.out.println("N�o h� mais vagas dispon�veis para "+guerreiro.getProfissao()); // Sa�da esperada para quando n�o h� vagas dispon�veis
			return false;
		}		
		return true;
	}
	
	/**
	 * Este m�todo adiciona o guerreiro no cl� caso ele passe nas valida��es de n�vel e de disponibilidade de vagas.
	 * @param guerreiro
	 */
	public void adicionaNoClan(Guerreiro guerreiro){
		if(validaGuerreiro(guerreiro)){
			this.guerreiros.add(guerreiro);
			this.vagas -= guerreiro.vagasOcupadas(); // diminui o n�mero de vagas dispon�veis de acordo com o n�mero de vagas que o guerreiro ocupa
		}
	}
	
	/**
	 * Para cada guerreiro que entrou no cl�, est� m�todo imprime a sa�da esperada &ltESPECIALIDADE&gt n�vel &ltNIVEL&gt  se apresentando. Meu lema �: &ltLEMA&gt
	 */
	public void listaInscritos(){
		for(Guerreiro guerreiro: guerreiros){
			String saida = String.format("%s n�vel %d se apresentando. Meu lema �: %s",guerreiro.getProfissao(), guerreiro.getNivel(), guerreiro.getLema());
			System.out.println(saida);
		}
	}
	
}
