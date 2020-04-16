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
	public Istruzione[] istruzioni;
	static Variabile[] variabili;
	String[] argomenti;
	Termine terminato ;
	
	public Programma(Istruzione... istruzioni) {
		this.istruzioni = istruzioni;
		this.variabili = new Variabile[Variabile.getMaxVariabili()];
	}
	
	public static Programma of(Istruzione... istruzioni) {
		ArrayList<Istruzione> ist2 = new ArrayList<Istruzione>();
		for(Istruzione ist : istruzioni) {
			ist2.add(ist);
		}
		return new Programma(istruzioni);
	}
	static public Programma fromFile(String f) throws NumberFormatException, OperatoreNonTrovatoException, TipiIncopamtibiliException { // SICURAMENTE STATIC
		String riga ;
		ArrayList<Istruzione> ist = new ArrayList<Istruzione>();
		Istruzione[] is = null ;
		try (BufferedReader b =Files.newBufferedReader(Paths.get(f))){
			while(b.ready()) {
				riga = b.readLine();
				ist.add(parse(riga));//SISTAMA
			}
			is = new Istruzione[ist.size()];
			int i = 0;
			for(Istruzione ist2 : ist) {//SISTEMA 
				is[i++]= ist2;
			}
			
		}
		
		catch(IOException e) {
			System.out.println(e);
		}
		return new Programma(is);
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
				String[] selezione =riga.split("ELSE",2);
				if(selezione.length==1) {// non ha else
					String[] ifThen =selezione[0].split("THEN",2);
					//String[] espressione = selezione[0].substring(3).split(" ");// argometnto escludo if e spazi da 3incluso , lunghezza array 3 (arg op arg istr)
					//EspressioneConfronto.Operatore.getOperatore(espressione[1]);//operatore
					String[] confronto = ifThen[0].substring(3).split(" ");// il confronto
					String[] istruzioniThen = ifThen[1].split(":");
					Istruzione ist = null;
					EspressioneConfronto.Operatore.getOperatore(confronto[1]);//operatore
					if(confronto[0].startsWith("$")) {
						if(confronto[2].startsWith("$")) { 
							EspressioneConfronto e = new EspressioneConfronto(variabili[Integer.parseInt(""+confronto[0].charAt(1))],variabili[Integer.parseInt(""+confronto[2].charAt(1))],EspressioneConfronto.Operatore.getOperatore(confronto[1]));
							for(int i = 0;i<istruzioniThen.length;i++) {
								ist = parse(istruzioniThen[i]);//RICORSIONE
							}
							//return new Selezione(e,ist,null);//istruzione senza then
						}
					}
					return new Print(Costante.of(argomento));

				}
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
				return k<istruzioni.length;	
			}

			@Override
			public Istruzione next() {
				return hasNext()? istruzioni[k++]:null;
			}	
		};
	}

	
	
	
	
	
}







