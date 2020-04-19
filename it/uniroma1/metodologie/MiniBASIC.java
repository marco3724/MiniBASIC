package it.uniroma1.metodologie;


import eccezioni.OperatoreNonTrovatoException;
import eccezioni.TipiIncopamtibiliException;
import espressioni.*;
import espressioni.EspressioneConfronto.Operatore;
import espressioni.Variabile.Nome;
import istruzioni.Assegna;
import istruzioni.Etichetta;
import istruzioni.Istruzione;
import istruzioni.Print;
import istruzioni.Selezione;


public class MiniBASIC {
	Programma programma;
	public MiniBASIC(Programma programma) {
		this.programma = programma;
	}
	public void esegui() {
		for(int i = 0;i<programma.getIstruzioni().size();i++) {
			programma.getIstruzioni().get(i).esegui();;
		}
		for(Variabile e :programma.variabili) {
			System.out.println(e);
		}
		for(Etichetta e :programma.etichette) {
			System.out.println(e);
		}
	}

}
