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
import espressioni.EspressioneSomma;
import espressioni.Intero;
import espressioni.Stringa;
import espressioni.Tipo;
import espressioni.Variabile;
import espressioni.Variabile.Nome;
import istruzioni.*;
import espressioni.Tipo;

public class Programma implements Iterable<Istruzione> {
	public static ArrayList<Istruzione> istruzioni;
	static Variabile[] variabili =  new Variabile[Variabile.getMaxVariabili()]; // il massimo delle variabili sara uguale al numero e la loro posizione è dopo il $

	
	public Programma(Istruzione... istruzioni) {
		this.istruzioni = new ArrayList<Istruzione>();
		for(Istruzione i: istruzioni) 
			this.istruzioni.add(i);		
	}
	
	public Programma(ArrayList<Istruzione> istruzioni) {
		this.istruzioni = istruzioni;
	}
	
	public static Programma of(Istruzione... istruzioni) {
		variabili = new Variabile[Variabile.getMaxVariabili()];
		return new Programma(istruzioni);
	}
	
	static public Programma fromFile(String f) throws NumberFormatException, OperatoreNonTrovatoException, TipiIncopamtibiliException { // SICURAMENTE STATIC
		String riga ;
		//variabili = new Variabile[Variabile.getMaxVariabili()];
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
		String argomento = riga.split(" ",2)[1];
		switch(istruzione) {
			case "PRINT":
				if(argomento.startsWith("$")) return new Print(variabili[Integer.parseInt(""+argomento.charAt(1))]);
				return new Print(Costante.of(argomento));
			case "REM": return new Commento(argomento);
			case "IF":  return parseSelezione(riga);
			case "WHILE": return parseWhileDo(riga);
			case "GOTO"	:
			case "END"	: return new Termine();
			default:
				if(istruzione.startsWith("$")) return  parseAssegna(argomento, istruzione);
				if(istruzione.endsWith(":")) return new Etichetta(istruzione,istruzioni.size());
		}
		return null;
	}
	
	private static Assegna parseAssegna(String argomento,String istruzione) throws TipiIncopamtibiliException {
		String[] valore = argomento.split(" ",2);
		if(!(valore[1].contains(" + ")) ) {
			if(valore[1].startsWith("$")) {
				if(variabili[Integer.parseInt(""+valore[1].charAt(1))]== null) variabili[Integer.parseInt(""+valore[1].charAt(1))] = new Variabile(Variabile.Nome.valueOf(valore[1]),"");        
				return new Assegna(variabili[Integer.parseInt(""+istruzione.charAt(1))],variabili[Integer.parseInt(""+valore[1].charAt(1))]);
				}
			else variabili[Integer.parseInt(""+istruzione.charAt(1))] = new Variabile(Variabile.Nome.valueOf(istruzione),valore[1]);//variabile da essere assegnato
			return new Assegna(variabili[Integer.parseInt(""+istruzione.charAt(1))],valore[1]);
			
		}
		
		//System.out.println(valore[1]+"HUAAAYYY");
		String[] concatenazione = valore[1].split(" [+] ");
		//System.out.println(concatenazione[1]+"HUAAxdAYYY");
		Espressione[] valori = new Espressione[concatenazione.length];
		int i = 0;
		for(String v: concatenazione) 
		{
			if(v.startsWith("$")) valori[i++] = variabili[Integer.parseInt(""+v.charAt(1))];
			else valori[i++] = Costante.of(v);
		}
		EspressioneSomma es = new EspressioneSomma(valori);
		if(variabili[Integer.parseInt(""+istruzione.charAt(1))]== null) 
			variabili[Integer.parseInt(""+istruzione.charAt(1))] = new Variabile(Variabile.Nome.valueOf(istruzione),es.getTipo()); //variabile da essere assegnato NON DEVE ESSRE ECREATO
		//System.out.println(es+"IL VALORE riga 109 programma");
		return new Assegna(variabili[Integer.parseInt(""+istruzione.charAt(1))],es);
	}
	
	private static Selezione parseSelezione(String riga) throws OperatoreNonTrovatoException, NumberFormatException, TipiIncopamtibiliException {
		String[] selezione =riga.split("ELSE",2);//if...else....
		String[] ifThen =selezione[0].split("THEN",2);//if...then...
		EspressioneConfronto e;// l'espressione di confronto if(e)
		String[] strThen = ifThen[1].split(" : ");//then.... formsto testo-da convertire
		
		String[] confronto = ifThen[0].substring(3).split(" ");// il confronto if(...)
		If istruzioneIf = parseConfronto(confronto,strThen);
		if(selezione.length==1) return new Selezione(istruzioneIf,null);
		String[] strElse =selezione[1].split(":");//else
		Istruzione[] istElse = new Istruzione[strElse.length];
		for(int i = 0;i<strElse.length;i++) {
			istElse[i]=parse(strElse[i]);//RICORSIONE  per prendere tutte le istruzioni - non dovrebbe entrare qua dentro durante la ricorsione
		}
		return new Selezione(istruzioneIf,istElse);
	}
	
	private static Iterazione parseWhileDo(String riga) throws OperatoreNonTrovatoException, NumberFormatException, TipiIncopamtibiliException {
		String[] selezione =riga.split("DO",2);//if...else....
		System.out.println(selezione[0]+"  LOOOOL   "+selezione[1]);
		String condizione = selezione[0].substring(6);//inizia direttamete dalla condizione
		System.out.println(condizione);
		String strIstruzione = selezione[1];//inizio direttamente dall'istruzioni
		System.out.println(strIstruzione+"mac so");
		System.out.println("ARRIVO QUA");
		If istruzioneIf =  parseConfronto(condizione.split(" "),strIstruzione.split(" : "));
		System.out.println("ARRIVO QUAAA");
		return new Iterazione(istruzioneIf);
	}
	
	private static If parseConfronto(String[] confronto,String[] strThen) throws OperatoreNonTrovatoException, NumberFormatException, TipiIncopamtibiliException {
		Istruzione[] istThen = new Istruzione[strThen.length];//lista di istruzioni del Then
		EspressioneConfronto e;// l'espressione di confronto if(e)
		EspressioneConfronto.Operatore.getOperatore(confronto[1]);//operatore (><=..)
		EspressioneConfronto.Operatore operatore = EspressioneConfronto.Operatore.getOperatore(confronto[1]);
		// espressione confronto
		if(confronto[0].startsWith("$")) {//se è una variabile
			if(confronto[2].startsWith("$")) { //se anche il scondo è una variabile
				e = new EspressioneConfronto(variabili[Integer.parseInt(""+confronto[0].charAt(1))],variabili[Integer.parseInt(""+confronto[2].charAt(1))],operatore); //allora confronto 2 variabili
			}
			else {//il primo operando è una variabile la seconda no
				e = new EspressioneConfronto(variabili[Integer.parseInt(""+confronto[0].charAt(1))],Costante.of(confronto[2]),operatore); //allora confronto 1 variabile con una costante
			}
		}
		else {// vuol dire che il primo operando è una costante
			if(confronto[2].startsWith("$")) { //se  il scondo è una variabile
				e = new EspressioneConfronto(Costante.of(confronto[0]),variabili[Integer.parseInt(""+confronto[2].charAt(1))],operatore); //allora confronto costante - variabile
			}
			else {
				e = new EspressioneConfronto(Costante.of(confronto[0]),Costante.of(confronto[2]),operatore); //allora confronto costante - variabile
			}
			
		}
		for(int i = 0;i<strThen.length;i++) {
			istThen[i]=parse(strThen[i]);//RICORSIONE  per prendere tutte le istruzioni - no entrare qua dentro durante la ricorsione
		}
		return new If(e,istThen);
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







