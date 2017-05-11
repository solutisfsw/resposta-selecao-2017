package br.com.solutis.recrutamento.clan.personagem;

public class GuerreiroFactory {
	
	/** Cria um guerreiro baseado na entrada */
	public static Guerreiro criaGuerreiro(String especialidade, int nivel, String lema){		
		switch(especialidade){
		case "A":
		case "Arqueiro":
			return new Arqueiro(nivel, lema);
		case "C":
		case "Cavaleiro":
			return new Cavaleiro(nivel, lema);
		case "CS":
		case "Cavaleiro Sagrado":
			return new CavaleiroSagrado(nivel, lema);
		case "CD":
		case "Cavaleiro Dragão":
			return new CavaleiroDragao(nivel, lema);
		case "M":
		case "Mago":
			return new Mago(nivel, lema);
		case "MF":
		case "Mago de Fogo":
			return new MagoFogo(nivel, lema);
		case "MG":
		case "Mago de Gelo":
			return new MagoGelo(nivel, lema);
		default:
			return null;
		}
	}

}
