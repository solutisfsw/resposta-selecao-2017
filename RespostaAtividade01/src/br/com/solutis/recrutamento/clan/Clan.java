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

	// preciso de uma lista de todos os guerreiros do cl�
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

	// este m�todo deve verificar se o cl� est� ou n�o apto para batalha
	public boolean verificaPreparacaoParaBatalha() {

		boolean mortosVivosEncontrados = procuraMortosVivoNoClan();
		
		if(mortosVivosEncontrados){ //NAO PODE ALTERAR ISTO
			System.out.println("Encontramos zumbis no cl� ! Soem os alar.. ahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
			throw new RuntimeException();
		}
		// s� estar�o aptos para batalha se estiverem vivos e o o hp for maior
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
		// s� estar�o aptos para batalha se o somat�rio dos n�veis dos
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
				System.out.println("Esta mensagem n�o deve aparecer nunca. N�o precisa se preocupar, de verdade");
			}
			if(mortosVivosEncontrados)
				break;
		}
		
		return mortosVivosEncontrados;
	}

	// vamos curar os guerreiros feridos	
	/**
	 * RESPOSTAS ( Esta resposta est� relacionada a uma explica��o na classe Mago)
	 * 
	 * Note que neste m�todo os arqueiros e os cavaleiros s�o curados atrav�s do m�todo <b>recebeCura<b>. Por outro lado,
	 * os magos est�o sendo curados via acesso direto a vari�vel hp. 
	 * Enquanto o m�todo <b>recebeCura</b> verifica se o guerreiro est� morto antes de cura-lo, o acesso direto a vari�vel n�o faz isso
	 * ocasionando o nosso problema com zumbis.
	 * 
	 * Para corrigir isso, basta trocar o acesso direto a vari�vel pelo m�todo <b>recebeCura</b>
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
				System.out.println("N�o sei quem vc � guerreiro");
			}
	}

	/**
	 * RESPOSTA
	 * 
	 * Atente para a l�gica deste c�digo. Em cada instru��o <b>while</b>, o iterator de um das listas � utilizado para percorrer todos os elementos do vetor.
	 * Quando um guerreiro que n�o est� vivo � encontrado, o mesmo � removido. No entanto, ocorre um problema no �ltimo <b>while</b>.
	 * 
	 *  O iterator da lista de magos � utilizado na condi��o do while, por�m, o iterator da lista de arqueiros � utilizado para checar 
	 *  se o guerreiro est� vivo e para remov�-lo. Este c�digo gera uma exe��o quando executado e est� exce��o � capturada no m�todo <b>main</b> da classe
	 *  Atividade01. Esta resposta continua l�.
	 *  
	 *  Para corrigir o erro basta trocar para itMago, as linhas que est�o utilizando itArqueiros no �ltimo while. 
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

	// guerreiros abaixo do n�vel 5 n�o podem entrar no cl�
	public void adicionaNoClan(Arqueiro arqueiro) {
		if (arqueiro.isVivo()) {
			if (arqueiro.getLevel() < 5) {
				System.out.println("Desculpe. Voc� n�o tem n�vel suficiente para entrar no cl�.");
			} else {
				System.out.println("Bem vindo ao clan");
				arqueiros.add(arqueiro);
				guerreiros.add(arqueiro);
			}
		} else {
			System.out.println("Desculpe. N�o aceitamos zumbis");
		}
	}

	// guerreiros abaixo do n�vel 5 n�o podem entrar no cl�
	public void adicionaNoClan(Cavaleiro cavaleiro) {
		if (cavaleiro.isVivo()) {
			if (cavaleiro.getLevel() < 5) {
				System.out.println("Desculpe. Voc� n�o tem n�vel suficiente para entrar no cl�.");
			} else {
				System.out.println("Bem vindo ao clan");
				cavaleiros.add(cavaleiro);
				guerreiros.add(cavaleiro);
			}
		} else {
			System.out.println("Desculpe. N�o aceitamos zumbis");
		}
	}

	// guerreiros abaixo do n�vel 5 n�o podem entrar no cl�
	public void adicionaNoClan(Mago mago) {
		if (mago.isVivo()) {
			if (mago.getLevel() < 5) {
				System.out.println("Desculpe. Voc� n�o tem n�vel suficiente para entrar no cl�.");
			} else {
				System.out.println("Bem vindo ao clan");
				magos.add(mago);
				guerreiros.add(mago);
			}
		} else {
			System.out.println("Desculpe. N�o aceitamos zumbis");
		}
	}

}
