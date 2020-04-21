package it.uniroma1.metodologie;

import istruzioni.Istruzione;
/**
 * questa classe serve per eseguire programmi
 * @author uni
 *
 */
public class MiniBASIC {
	/**
	 * esegue un programma
	 * @param programma
	 */
	public void esegui(Programma programma) {
		for(Istruzione i : programma) 
			i.esegui();
		
		}
	}

