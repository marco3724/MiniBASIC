package istruzioni;

import eccezioni.TipiIncopamtibiliException;
import espressioni.Costante;
import espressioni.Espressione;
import espressioni.Variabile;

/**
 * assegna ad una variabile il valore di una costante o variabile
 * @author marco
 *
 */
public class Assegna implements Istruzione {
	/**
	 * variabile da assegnare un valore
	 */
	private Variabile variabile;
	/**
	 * l'argometo puo essere una variabile o una costante
	 */
	private Espressione argomento;
	/**
	 * 
	 * @param variabile 
	 * @param argomento puo essere una variabile/costante di tipo booleano/Stringa /intero
	 */
	public Assegna(Variabile variabile,String argomento) {
		this(variabile,Costante.of(argomento));
	}
	public Assegna(Variabile variabile,int argomento) {
		this(variabile,Costante.of(""+argomento));
	}
	public Assegna(Variabile variabile,boolean argomento) {
		this(variabile,Costante.of(""+argomento));
	}
	public Assegna(Variabile variabile,Espressione argomento) {
		this.variabile = variabile;
		this.argomento = argomento;
	}
	/**
	 * assegna il valore , se il tipo non � compatibile lancia un errore
	 */
	@Override
	public void esegui()  {
		try {
		//System.out.println("riga 46 assegna ARGOMENTO"+argomento.getTipo());
		variabile.setValore(""+argomento.getValore());
		//System.out.println(variabile.getValore());
		}
		catch(TipiIncopamtibiliException e) {
			System.out.println(e+" "+variabile+" "+argomento.getValore());
		}
	}

}


