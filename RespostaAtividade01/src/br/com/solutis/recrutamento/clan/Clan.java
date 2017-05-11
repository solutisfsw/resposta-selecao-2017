package br.com.solutis.recrutamento.clan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import br.com.solutis.recrutamento.clan.personagem.Arqueiro;
import br.com.solutis.recrutamento.clan.personagem.Cavaleiro;
import br.com.solutis.recrutamento.clan.personagem.Mago;

public class Clan {

	protected List<Arqueiro> arqueiros = new ArrayList<>();
	protected List<Cavaleiro> cavaleiros = new ArrayList<>();
	protected List<Mago> magos = new ArrayList<>();

	// preciso de uma lista de todos os guerreiros do clã
	protected List<Object> guerreiros = new ArrayList<>();

	public Clan(int numeroArqueiros, int numeroCavaleiros, int numeroMagos) {

		for (int i = 0; i < numeroArqueiros; i++) {
			Arqueiro arqueiro = new Arqueiro();
			arqueiros.add(arqueiro);
			guerreiros.add(arqueiro);
		}

		for (int i = 0; i < numeroCavaleiros; i++) {
			Cavaleiro cavaleiro = new Cavaleiro();
			cavaleiros.add(cavaleiro);
			guerreiros.add(cavaleiro);
		}

		for (int i = 0; i < numeroMagos; i++) {
			Mago mago = new Mago();
			magos.add(mago);
			guerreiros.add(mago);

		}
	}

	// este método deve verificar se o clã está ou não apto para batalha
	public boolean verificaPreparacaoParaBatalha() {

		boolean mortosVivosEncontrados = procuraMortosVivoNoClan();
		
		if(mortosVivosEncontrados){ //NAO PODE ALTERAR ISTO
			System.out.println("Encontramos zumbis no clã ! Soem os alar.. ahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
			throw new RuntimeException();
		}
		// só estarão aptos para batalha se estiverem vivos e o o hp for maior
		// ou igual a 30
		int aptosParaBatalha = 0;
		for (Object guerreiro : guerreiros)
			if (guerreiro instanceof Arqueiro) { // se for um arqueiro
				Arqueiro arqueiro = (Arqueiro) guerreiro;
				if (arqueiro.isVivo() && arqueiro.getHp() >= 30)
					aptosParaBatalha++;
			} else if (guerreiro instanceof Cavaleiro) { // se for um cavaleiro
				Cavaleiro cavaleiro = (Cavaleiro) guerreiro;
				if (cavaleiro.isVivo() && cavaleiro.getHp() >= 30)
					aptosParaBatalha++;
			} else if (guerreiro instanceof Mago) { // se for um mago
				Mago mago = (Mago) guerreiro;
				if (mago.isVivo() && mago.getHp() >= 30)
					aptosParaBatalha++;
			}

		if (aptosParaBatalha < 12) { //NAO PODE ALTERAR ISTO
			return false;
		}

		int level = 0;
		// só estarão aptos para batalha se o somatório dos níveis dos
		// guerreiros vivos for maior ou igual a 60
		for (Arqueiro arqueiro : arqueiros)
			if (arqueiro.isVivo())
				level += arqueiro.getLevel();
		for (Cavaleiro cavaleiro : cavaleiros)
			if (cavaleiro.isVivo())
				level += cavaleiro.getLevel();
		for (Mago mago : magos)
			if (mago.isVivo())
				level += mago.getLevel();

		if (level < 60) { //NAO PODE ALTERAR ISTO
			return false;
		}

		return true;
	}

	private boolean procuraMortosVivoNoClan() {
		boolean mortosVivosEncontrados = false;
		for (Object guerreiro : guerreiros){
			try{
				mortosVivosEncontrados = (Boolean) guerreiro.getClass().getMethod("isMortoVivo").invoke(guerreiro);
			}catch(Exception e){
				System.out.println("Esta mensagem não deve aparecer nunca. Não precisa se preocupar, de verdade");
			}
			if(mortosVivosEncontrados)
				break;
		}
		
		return mortosVivosEncontrados;
	}

	// vamos curar os guerreiros feridos	
	/**
	 * RESPOSTAS ( Esta resposta está relacionada a uma explicação na classe Mago)
	 * 
	 * Note que neste método os arqueiros e os cavaleiros são curados através do método <b>recebeCura<b>. Por outro lado,
	 * os magos estão sendo curados via acesso direto a variável hp. 
	 * Enquanto o método <b>recebeCura</b> verifica se o guerreiro está morto antes de cura-lo, o acesso direto a variável não faz isso
	 * ocasionando o nosso problema com zumbis.
	 * 
	 * Para corrigir isso, basta trocar o acesso direto a variável pelo método <b>recebeCura</b>
	 * 
	 */
	public void curaGuerreirosFeridos() {
		for (Object guerreiro : guerreiros)
			if (guerreiro instanceof Arqueiro) { // se for um arqueiro
				Arqueiro arqueiro = (Arqueiro) guerreiro;
				arqueiro.recebeCura(30 + new Random().nextInt(30));
			} else if (guerreiro instanceof Cavaleiro) { // se for um cavaleiro
				Cavaleiro cavaleiro = (Cavaleiro) guerreiro;
				cavaleiro.recebeCura(30 + new Random().nextInt(30));
			} else if (guerreiro instanceof Mago) { // se for um mago
				Mago mago = (Mago) guerreiro;
				mago.hp = 30 + new Random().nextInt(30);
			} else {
				System.out.println("Não sei quem vc é guerreiro");
			}
	}

	/**
	 * RESPOSTA
	 * 
	 * Atente para a lógica deste código. Em cada instrução <b>while</b>, o iterator de um das listas é utilizado para percorrer todos os elementos do vetor.
	 * Quando um guerreiro que não está vivo é encontrado, o mesmo é removido. No entanto, ocorre um problema no último <b>while</b>.
	 * 
	 *  O iterator da lista de magos é utilizado na condição do while, porém, o iterator da lista de arqueiros é utilizado para checar 
	 *  se o guerreiro está vivo e para removê-lo. Este código gera uma exeção quando executado e está exceção é capturada no método <b>main</b> da classe
	 *  Atividade01. Esta resposta continua lá.
	 *  
	 *  Para corrigir o erro basta trocar para itMago, as linhas que estão utilizando itArqueiros no último while. 
	 * 
	 */
	public void enterraMortos() {
		Iterator<Arqueiro> itArqueiros = this.arqueiros.iterator();
		Iterator<Cavaleiro> itCavaleiros = this.cavaleiros.iterator();
		Iterator<Mago> itMago = this.magos.iterator();

		while (itCavaleiros.hasNext())
			if (!itCavaleiros.next().isVivo())
				itCavaleiros.remove();

		while (itArqueiros.hasNext())
			if (!itArqueiros.next().isVivo())
				itArqueiros.remove();

		while (itMago.hasNext())
			if (!itArqueiros.next().isVivo())
				itArqueiros.remove();

	}

	// guerreiros abaixo do nível 5 não podem entrar no clã
	public void adicionaNoClan(Arqueiro arqueiro) {
		if (arqueiro.isVivo()) {
			if (arqueiro.getLevel() < 5) {
				System.out.println("Desculpe. Você não tem nível suficiente para entrar no clã.");
			} else {
				System.out.println("Bem vindo ao clan");
				arqueiros.add(arqueiro);
				guerreiros.add(arqueiro);
			}
		} else {
			System.out.println("Desculpe. Não aceitamos zumbis");
		}
	}

	// guerreiros abaixo do nível 5 não podem entrar no clã
	public void adicionaNoClan(Cavaleiro cavaleiro) {
		if (cavaleiro.isVivo()) {
			if (cavaleiro.getLevel() < 5) {
				System.out.println("Desculpe. Você não tem nível suficiente para entrar no clã.");
			} else {
				System.out.println("Bem vindo ao clan");
				cavaleiros.add(cavaleiro);
				guerreiros.add(cavaleiro);
			}
		} else {
			System.out.println("Desculpe. Não aceitamos zumbis");
		}
	}

	// guerreiros abaixo do nível 5 não podem entrar no clã
	public void adicionaNoClan(Mago mago) {
		if (mago.isVivo()) {
			if (mago.getLevel() < 5) {
				System.out.println("Desculpe. Você não tem nível suficiente para entrar no clã.");
			} else {
				System.out.println("Bem vindo ao clan");
				magos.add(mago);
				guerreiros.add(mago);
			}
		} else {
			System.out.println("Desculpe. Não aceitamos zumbis");
		}
	}

}
