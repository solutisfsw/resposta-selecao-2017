package br.com.solutis.recrutamento.atividade02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.solutis.recrutamento.clan.Clan;
import br.com.solutis.recrutamento.clan.personagem.GuerreiroFactory;


public class Atividade02 {

	/**
	 * *
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		File entrada = new File(args[0]);	// recebe o arquivo através do parâmetro args do método main
		
		Scanner in = new Scanner(entrada); // prepara o arquivo para leitura
		
		int nivelMinimo = Integer.parseInt(in.nextLine());  
		int numeroDeVagas = Integer.parseInt(in.nextLine());
		
		Clan clan = new Clan(nivelMinimo, numeroDeVagas);
		
		while(in.hasNextLine()){			
			String linha = in.nextLine();
			
			if(linha.startsWith("#")) // achou o fim das inscrições, para de ler o arquivo.
				break;
			
			String[] dadosDaInscricao = linha.split("_");
			
			String especialidade = dadosDaInscricao[0];
			int nivel = Integer.parseInt(dadosDaInscricao[1]);
			String lema = dadosDaInscricao[2];			
			
			clan.adicionaNoClan(GuerreiroFactory.criaGuerreiro(especialidade, nivel, lema));
		}
		System.out.println("Inscrições encerradas.");
		in.close();		
		
		clan.listaInscritos();
	}

}
