package it.uniroma1.metodologie;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;


import eccezioni.OperatoreNonTrovatoException;
import eccezioni.TipiIncopamtibiliException;
import espressioni.Booleano;
import espressioni.Costante;
import espressioni.Espressione;
import espressioni.EspressioneConfronto;
import espressioni.Intero;
import espressioni.Stringa;
import espressioni.Tipo;
import espressioni.Variabile;
import espressioni.Variabile.Nome;
import istruzioni.*;
import espressioni.Tipo;

public class Programma implements Iterable<Istruzione> {
	public ArrayList<Istruzione> istruzioni;
	static Variabile[] variabili; // il massimo delle variabili sara uguale al numero e la loro posizione è dopo il $
	String[] argomenti;
	Termine terminato ;
	
	public Programma(Istruzione... istruzioni) {
		this.istruzioni = new ArrayList<Istruzione>();
		
		for(Istruzione i: istruzioni) 
			this.istruzioni.add(i);
		this.variabili = new Variabile[Variabile.getMaxVariabili()];
	}
	
	public Programma(ArrayList<Istruzione> istruzioni) {
		this.istruzioni = istruzioni;
		this.variabili = new Variabile[Variabile.getMaxVariabili()];
	}
	
	public static Programma of(Istruzione... istruzioni) {
		return new Programma(istruzioni);
	}
	static public Programma fromFile(String f) throws NumberFormatException, OperatoreNonTrovatoException, TipiIncopamtibiliException { // SICURAMENTE STATIC
		String riga ;
		ArrayList<Istruzione> ist = new ArrayList<Istruzione>();
		
		try (BufferedReader b =Files.newBufferedReader(Paths.get(f))){
			while(b.ready()) {
				riga = b.readLine();
				ist.add(parse(riga));//SISTAMA
			}

			
		}
		
		catch(IOException e) {
			System.out.println(e);
		}
		return new Programma(ist);
		}
	
	
	private static Istruzione parse(String riga) throws OperatoreNonTrovatoException, NumberFormatException, TipiIncopamtibiliException {
		riga = riga.trim();
		String istruzione = riga.split(" ")[0];
		String argomento = riga.split(" ")[1];
		switch(istruzione) {
			case "PRINT":
				if(argomento.startsWith("$")) return new Print(variabili[Integer.parseInt(""+argomento.charAt(1))]);
				return new Print(Costante.of(argomento));
			case "REM": return new Commento(argomento);
			case "IF": 
				String[] selezione =riga.split("ELSE",2);//if...else....
				String[] ifThen =selezione[0].split("THEN",2);//if...then...
				String[] confronto = ifThen[0].substring(3).split(" ");// il confronto if(...)
				String[] istruzioniThen = ifThen[1].split(":");//then.... formsto testo-da convertire
				Istruzione[] istThen = new Istruzione[istruzioniThen.length];//lista di istruzioni del Then
				EspressioneConfronto.Operatore.getOperatore(confronto[1]);//operatore (><=..)
				EspressioneConfronto e; // l'espressione di confronto if(e)
				for(int i = 0;i<istruzioniThen.length;i++) {
					istThen[i]=parse(istruzioniThen[i]);//RICORSIONE  per prendere tutte le istruzioni - no entrare qua dentro durante la ricorsione
				}
				// espressione confronto
				if(confronto[0].startsWith("$")) {//se è una variabile
					if(confronto[2].startsWith("$")) { //se anche il scondo è una variabile
						 e = new EspressioneConfronto(variabili[Integer.parseInt(""+confronto[0].charAt(1))-1],variabili[Integer.parseInt(""+confronto[2].charAt(1))-1],EspressioneConfronto.Operatore.getOperatore(confronto[1])); //allora confronto 2 variabili
					}
					else {//il primo operando è una variabile la seconda no
						 e = new EspressioneConfronto(variabili[Integer.parseInt(""+confronto[0].charAt(1))-1],Costante.of(confronto[2]),EspressioneConfronto.Operatore.getOperatore(confronto[1])); //allora confronto 1 variabile con una costante
					}
				}
				else {// vuol dire che il primo operando è una costante
					if(confronto[2].startsWith("$")) { //se  il scondo è una variabile
						 e = new EspressioneConfronto(Costante.of(confronto[0]),variabili[Integer.parseInt(""+confronto[2].charAt(1))-1],EspressioneConfronto.Operatore.getOperatore(confronto[1])); //allora confronto costante - variabile
					}
					else {
						 e = new EspressioneConfronto(Costante.of(confronto[0]),Costante.of(confronto[2]),EspressioneConfronto.Operatore.getOperatore(confronto[1])); //allora confronto costante - variabile
					}
					
				}
				if(selezione.length==1) return new Selezione(e,istThen,null);
				String[] strElse =selezione[1].split(":");//else
				Istruzione[] istElse = new Istruzione[strElse.length];
				for(int i = 0;i<strElse.length;i++) {
					istElse[i]=parse(strElse[i]);//RICORSIONE  per prendere tutte le istruzioni - no entrare qua dentro durante la ricorsione
				}
				return new Selezione(e,istThen,istElse);
				
			case "WHILE":
				break;
			
				//return null;
		}
		return null;
		
	}
	
	@Override
	public Iterator<Istruzione> iterator() {
		
		return new Iterator<>(){
			private int k;

			@Override
			public boolean hasNext() {
				return k<istruzioni.size();	
			}

			@Override
			public Istruzione next() {
				return hasNext()? istruzioni.get(k++):null;
			}	
		};
	}

	
	
	
	
	
}







