package it.uniroma1.metodologie;

import istruzioni.Istruzione;

public class MiniBASIC {

	public void esegui(Programma programma) {
		for(Istruzione i : programma) {
			i.esegui();
		}
			
		}
	}


/*
 * 
 * for(int i = 0;i<programma.getIstruzioni().size();i++) {
			programma.getIstruzioni().get(i).esegui();
			if(programma.getGoTo()==true) {
				i = programma.getWhere();
				programma.setGoTo(false);
				}
			}
 */
