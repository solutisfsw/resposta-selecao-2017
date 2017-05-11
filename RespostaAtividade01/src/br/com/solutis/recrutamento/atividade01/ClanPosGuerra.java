package br.com.solutis.recrutamento.atividade01;

import br.com.solutis.recrutamento.clan.Clan;
import br.com.solutis.recrutamento.clan.personagem.Mago;

public class ClanPosGuerra extends Clan{

	public ClanPosGuerra() {
		super(10, 5, 3);
		
		
		enviaMagosParaLuta();
		//nenhum dos nossos magos sobreviveu
		enviaCavaleirosParaLuta();
		//quatro dos nossos cavaleiros morreram
		enviaArqueirosParaLuta();
		// todos os arqueiros voltaram vivos;
		curaGuerreirosFeridos();
		//cuidamos dos nossos guerreiros feridos
	}
	
	private void enviaArqueirosParaLuta() {

	}


	private void enviaCavaleirosParaLuta() {
		for(int i = 0 ; i < 4; i ++){
			this.cavaleiros.get(i).diminuiHp(0);
		}
	}


	private void enviaMagosParaLuta() {
		for(Mago mago: magos){
			mago.diminuiHp(0);
		}
		
	}


}
