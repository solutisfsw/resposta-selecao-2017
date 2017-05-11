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
	 * Construtor do clã que recebe o número de vagas disponíveis e  o nível mínimo
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
			System.out.println("Inscrito não tem nível suficiente para entrar no clã"); // Saída esperada para quando o guerreiro não tem nível para entrar no clã
			return false;
		}
		if(vagas - guerreiro.vagasOcupadas() < 0){
			System.out.println("Não há mais vagas disponíveis para "+guerreiro.getProfissao()); // Saída esperada para quando não há vagas disponíveis
			return false;
		}		
		return true;
	}
	
	/**
	 * Este método adiciona o guerreiro no clã caso ele passe nas validações de nível e de disponibilidade de vagas.
	 * @param guerreiro
	 */
	public void adicionaNoClan(Guerreiro guerreiro){
		if(validaGuerreiro(guerreiro)){
			this.guerreiros.add(guerreiro);
			this.vagas -= guerreiro.vagasOcupadas(); // diminui o número de vagas disponíveis de acordo com o número de vagas que o guerreiro ocupa
		}
	}
	
	/**
	 * Para cada guerreiro que entrou no clã, esté método imprime a saída esperada &ltESPECIALIDADE&gt nível &ltNIVEL&gt  se apresentando. Meu lema é: &ltLEMA&gt
	 */
	public void listaInscritos(){
		for(Guerreiro guerreiro: guerreiros){
			String saida = String.format("%s nível %d se apresentando. Meu lema é: %s",guerreiro.getProfissao(), guerreiro.getNivel(), guerreiro.getLema());
			System.out.println(saida);
		}
	}
	
}
