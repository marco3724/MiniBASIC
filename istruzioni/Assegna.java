package istruzioni;

import eccezioni.TipiIncopamtibiliException;
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
	private String argomento;
	/**
	 * 
	 * @param variabile 
	 * @param argomento puo essere una variabile/costante di tipo booleano/Stringa /intero
	 */
	public Assegna(Variabile variabile,String argomento) {
		this.variabile = variabile;
		this.argomento = argomento;
	}
	public Assegna(Variabile variabile,int argomento) {
		this(variabile,""+argomento);
	}
	public Assegna(Variabile variabile,boolean argomento) {
		this(variabile,""+argomento);
	}
	public Assegna(Variabile variabile,Espressione argomento) {
		this(variabile,""+argomento.getValore());
	}
	/**
	 * assegna il valore , se il tipo non è compatibile lancia un errore
	 */
	@Override
	public void esegui()  {
		try {
		variabile.setValore(argomento);
		}
		catch(TipiIncopamtibiliException e) {
			System.out.println(e);
		}
	}

}


