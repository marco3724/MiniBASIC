package it.uniroma1.metodologie;

import eccezioni.OperatoreNonTrovatoException;
import eccezioni.TipiIncopamtibiliException;
import espressioni.*;
import espressioni.Variabile.Nome;
import istruzioni.*;

public class Test {
	public static void main(String[] args) throws NumberFormatException, OperatoreNonTrovatoException, TipiIncopamtibiliException {
		Programma p1 = Programma.fromFile("prova.txt");
		Programma p2 = Programma.of(new Assegna(new Variabile(Nome.$0,4),new Intero(8)),new Print("ciao"));
	
		new MiniBASIC().esegui(p2);

	}

}
