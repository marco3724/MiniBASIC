package it.uniroma1.metodologie;

import eccezioni.OperatoreNonTrovatoException;
import eccezioni.TipiIncopamtibiliException;

public class Test {
	public static void main(String[] args) throws NumberFormatException, OperatoreNonTrovatoException, TipiIncopamtibiliException {
		Programma p1 = Programma.fromFile("prova.txt");
		new MiniBASIC(p1).esegui();
	}

}
