package it.uniroma1.metodologie;

import istruzioni.Istruzione;

public class MiniBASIC {

	public void esegui(Programma programma) {
		for(Istruzione i : programma) 
			i.esegui();
		
		}
	}

