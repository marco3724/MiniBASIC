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

public class Programma implements Iterable<Istruzione> {//FERMA QUI
	private ArrayList<Istruzione> istruzioni;
	private Variabile[] variabili ;// il massimo delle variabili sara uguale al numero dei nomi e la loro posizione è dopo il $
	private ArrayList<Etichetta> etichette ;
	static int indice = 0;
	Termine terminato;

	public Programma(Istruzione... istruzioni) {
		this.istruzioni = new ArrayList<Istruzione>();
		this.variabili = new Variabile[Variabile.getMaxVariabili()];
		for(Istruzione i: istruzioni) 
			this.istruzioni.add(i);		
	}
	
	public Programma(Variabile[] var,ArrayList<Istruzione> istruzioni,ArrayList<Etichetta> label) {
		this.istruzioni = new ArrayList<Istruzione>();
		for(Istruzione i: istruzioni) 
			this.istruzioni.add(i);
		variabili = var;
		etichette = label;
	}
	
	public Programma(ArrayList<Istruzione> istruzioni) {
		this.istruzioni = istruzioni;
	}
	
	public static Programma of(Istruzione... istruzioni) {
		return new Programma(istruzioni);
	}
	
	static public Programma fromFile(String f) throws NumberFormatException, OperatoreNonTrovatoException, TipiIncopamtibiliException { // SICURAMENTE STATIC
		String riga ;
		ArrayList<Istruzione> ist = new ArrayList<Istruzione>();
		ArrayList<Etichetta> label = new ArrayList<Etichetta>();
		//label.add(new Etichetta("END",0));
		Variabile[] var = new Variabile[Variabile.getMaxVariabili()];
		try (BufferedReader b =Files.newBufferedReader(Paths.get(f))){
			while(b.ready()) {
				riga = b.readLine();
				if(riga.equals("")) continue;
				ist.add(parse(riga,var,label));
				indice++;
			}	
		}
		catch(IOException e) {
			System.out.println(e);
		}
		//label.get(0).setPosizione(ist.size());
		//System.out.println(label.get(0).getPosizione());
		//ist.add(label.get(0));//cosi non sfora
		return new Programma(var,ist,label);
		}
	
	
	private static Istruzione parse(String riga,Variabile[] var,ArrayList<Etichetta> label) throws OperatoreNonTrovatoException, NumberFormatException, TipiIncopamtibiliException {
		riga = riga.trim();
		String istruzione = riga.split(" ")[0];
		String argomento = "";
		if(!istruzione.equals("END") && !istruzione.endsWith(":") )  argomento = riga.split(" ",2)[1];
		switch(istruzione) {
			case "PRINT":
				if(argomento.startsWith("$")) return new Print(var[Integer.parseInt(""+argomento.charAt(1))]);
				return new Print(Costante.of(argomento));
			case "REM": return new Commento(argomento);
			case "IF":  return parseSelezione(riga,var,label);
			case "WHILE": return parseWhileDo(riga,var,label);
			case "GOTO"	:return new Salto(label.get(trovaEtichetta(argomento,label)));// ho un salto alla posizione dell'etichetta nelle etichette che pero non ha ancora un posizione
			case "END"	: return new Termine();
			default:
				if(istruzione.startsWith("$")) return  parseAssegna(argomento, istruzione,var);
				if(istruzione.endsWith(":")) return creaEtichette(istruzione.substring(0, istruzione.length()-1),label);//senza -1 cosi ho direttamente l'istruzione successive
		}
		return null;
	}
	private static Etichetta creaEtichette(String etichetta,ArrayList<Etichetta> label) {
		if(label.get(trovaEtichetta(etichetta,label)).getPosizione() == -1) label.get(trovaEtichetta(etichetta,label)).setPosizione(indice+1);
		return label.get(trovaEtichetta(etichetta,label));
	}
	private static int trovaEtichetta(String etichetta,ArrayList<Etichetta> label) {
		int i = 0;
		for(Etichetta e:label) {
			if(etichetta.equals(e.getNome())) return i;
			i++;
		}
		label.add(new Etichetta(etichetta,-1));
		return i;
		
	}
	
	private static Assegna parseAssegna(String argomento,String istruzione,Variabile[] var) throws TipiIncopamtibiliException {
		String[] valore = argomento.split(" ",2);
		String[] concatenazione = valore[1].split(" [+] ");
		Espressione[] valori = new Espressione[concatenazione.length];
		int i = 0;
		for(String v: concatenazione) 
		{
			if(v.startsWith("$")) valori[i++] = var[Integer.parseInt(""+v.charAt(1))];
			else valori[i++] = Costante.of(v);
		}
		EspressioneSomma es = new EspressioneSomma(valori);
		if(var[Integer.parseInt(""+istruzione.charAt(1))]== null) 
			var[Integer.parseInt(""+istruzione.charAt(1))] = new Variabile(Variabile.Nome.valueOf(istruzione),es.getTipo()); //variabile da essere assegnato NON DEVE ESSRE ECREATO
		//System.out.println(es+"IL VALORE riga 109 programma");
		return new Assegna(var[Integer.parseInt(""+istruzione.charAt(1))],es);
	}
	
	private static Selezione parseSelezione(String riga,Variabile[] var,ArrayList<Etichetta> label) throws OperatoreNonTrovatoException, NumberFormatException, TipiIncopamtibiliException {
		String[] selezione =riga.split("ELSE",2);//if...else....
		String[] ifThen =selezione[0].split("THEN",2);//if...then...
		EspressioneConfronto e;// l'espressione di confronto if(e)
		String[] strThen = ifThen[1].split(" : ");//then.... formsto testo-da convertire
		
		String[] confronto = ifThen[0].substring(3).split(" ");// il confronto if(...)
		If istruzioneIf = parseConfronto(confronto,strThen,var,label);
		if(selezione.length==1) return new Selezione(istruzioneIf,new Etichetta("null",0));
		String[] strElse =selezione[1].split(":");//else
		Istruzione[] istElse = new Istruzione[strElse.length];
		for(int i = 0;i<strElse.length;i++) {
			istElse[i]=parse(strElse[i],var,label);//RICORSIONE  per prendere tutte le istruzioni - non dovrebbe entrare qua dentro durante la ricorsione
		}
		return new Selezione(istruzioneIf,istElse);
	}
	
	private static Iterazione parseWhileDo(String riga,Variabile[] var,ArrayList<Etichetta> label) throws OperatoreNonTrovatoException, NumberFormatException, TipiIncopamtibiliException {
		String[] selezione =riga.split("DO",2);
		String condizione = selezione[0].substring(6);//inizia direttamete dalla condizione
		String strIstruzione = selezione[1];//inizio direttamente dall'istruzioni
		If istruzioneWhileDo =  parseConfronto(condizione.split(" "),strIstruzione.split(" : "), var,label);
		return new Iterazione(istruzioneWhileDo);
	}
	
	private static If parseConfronto(String[] confronto,String[] strThen,Variabile[] var,ArrayList<Etichetta> label) throws OperatoreNonTrovatoException, NumberFormatException, TipiIncopamtibiliException {
		Istruzione[] istThen = new Istruzione[strThen.length];//lista di istruzioni del Then
		EspressioneConfronto e;// l'espressione di confronto if(e)
		EspressioneConfronto.Operatore.getOperatore(confronto[1]);//operatore (><=..)
		EspressioneConfronto.Operatore operatore = EspressioneConfronto.Operatore.getOperatore(confronto[1]);
		// espressione confronto
		if(confronto[0].startsWith("$")) {//se è una variabile
			if(confronto[2].startsWith("$")) { //se anche il scondo è una variabile
				e = new EspressioneConfronto(var[Integer.parseInt(""+confronto[0].charAt(1))],var[Integer.parseInt(""+confronto[2].charAt(1))],operatore); //allora confronto 2 variabili
			}
			else {//il primo operando è una variabile la seconda no
				e = new EspressioneConfronto(var[Integer.parseInt(""+confronto[0].charAt(1))],Costante.of(confronto[2]),operatore); //allora confronto 1 variabile con una costante
			}
		}
		else {// vuol dire che il primo operando è una costante
			if(confronto[2].startsWith("$")) { //se  il scondo è una variabile
				e = new EspressioneConfronto(Costante.of(confronto[0]),var[Integer.parseInt(""+confronto[2].charAt(1))],operatore); //allora confronto costante - variabile
			}
			else {
				e = new EspressioneConfronto(Costante.of(confronto[0]),Costante.of(confronto[2]),operatore); //allora confronto costante - variabile
			}
			
		}
		for(int i = 0;i<strThen.length;i++) {
			istThen[i]=parse(strThen[i],var,label);//RICORSIONE  per prendere tutte le istruzioni - no entrare qua dentro durante la ricorsione
		}
		return new If(e,istThen);
	}
	
	
	@Override
	public Iterator<Istruzione> iterator() {
		
		return new Iterator<Istruzione>() { 
			private int k; 
			
			@Override
			public boolean hasNext() {
				return k<istruzioni.size();	
			}
			@Override
			public Istruzione next() {
				if(istruzioni.get(k) instanceof Salto)
					k =((Salto) istruzioni.get(k)).getEtichetta().getPosizione();
				return hasNext() ? istruzioni.get(k++):null;
				
			}
	};
	}
}




