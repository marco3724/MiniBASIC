package it.uniroma1.metodologie;

import eccezioni.OperatoreNonTrovatoException;
import eccezioni.TipiIncopamtibiliException;
import espressioni.EspressioneConfronto.Operatore;
import espressioni.Variabile.Nome;
import istruzioni.Print;;

public class Test {
	public static void main(String[] args)  {
		try {
			Programma p1 = Programma.fromFile("prg/28/fibonacci.bas");
			Programma p2 = Programma.fromFile("prg/full/pari_dispari.bas");
			Programma p3 = Programma.fromFile("prg/full/prg1.bas");
			Programma p4 = Programma.fromFile("prg/full/fibonacci.bas");
			Programma p5 = Programma.fromFile("prg/full/ordina.bas");
			Programma p6 = Programma.fromFile("prg/28/successione.bas");

			System.out.println("1 test");
			new MiniBASIC().esegui(p1);
			System.out.println("\n2 test");
			new MiniBASIC().esegui(p2);
			System.out.println("\n3 test");
			new MiniBASIC().esegui(p3);
			System.out.println("\n4 test");
			new MiniBASIC().esegui(p4);
			System.out.println("\n5 test");
			new MiniBASIC().esegui(p5);
			System.out.println("\n6 test");
			new MiniBASIC().esegui(p6);
		
		}
		catch(Exception e) {System.out.println(e);}


				

	}

}
