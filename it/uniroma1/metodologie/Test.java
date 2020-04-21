package it.uniroma1.metodologie;

import eccezioni.OperatoreNonTrovatoException;
import eccezioni.TipiIncopamtibiliException;
import espressioni.*;
import espressioni.Variabile.Nome;
import istruzioni.*;

public class Test {
	public static void main(String[] args)  {
		try {
			Variabile v1 = new Variabile(Nome.$0,0);
			Variabile v2 = new Variabile(Nome.$0,0);
			Variabile v3 = new Variabile(Nome.$0,0);
			Variabile v4 = new Variabile(Nome.$0,0);
			Variabile v15 = new Variabile(Nome.$0,0);
			Variabile v16 = new Variabile(Nome.$0,0);
			Variabile v17 = new Variabile(Nome.$0,0);
			Variabile v18 = new Variabile(Nome.$0,0);
			Variabile v19 = new Variabile(Nome.$0,0);
			Variabile v10 = new Variabile(Nome.$0,0);
			//Variabile v102 = new Variabile(Nome.$0,0);
			
	
		Programma p1 = Programma.fromFile("prg/28/fibonacci.bas");
		Programma p2 = Programma.fromFile("prg/full/pari_dispari.bas");
		Programma p3 = Programma.fromFile("prg/full/prg1.bas");
		Programma p4 = Programma.fromFile("prg/full/fibonacci.bas");
		Programma p5 = Programma.fromFile("prg/full/ordina.bas");
		Programma p6 = Programma.fromFile("prg/28/successione.bas");
		Programma p7 = Programma.fromFile("prova.txt");
		new MiniBASIC().esegui(p7);
		}
		catch(Exception e) {System.out.println(e);}
/*
		new MiniBASIC().esegui(p1);//
		System.out.println("");
		System.out.println("");
		System.out.println("");*/
		
		//new MiniBASIC().esegui(p3);
		/*
		//new MiniBASIC().esegui(p4);
		//new MiniBASIC().esegui(p5);//
		System.out.println("");
		System.out.println("");
		System.out.println("");
		new MiniBASIC().esegui(p6);//*/
				

	}

}
