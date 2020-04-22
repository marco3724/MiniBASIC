package istruzioni;

import espressioni.Booleano;
import espressioni.Espressione;
import espressioni.Espressione.Tipo;
import espressioni.Intero;
import espressioni.Stringa;
/**
 * questa classe serve per costruire un oggetto di tipo Print la sua esecuzione consiste nel stampare a video un'espressione
 * @author marco
 *
 */
public class Print implements Istruzione {
	private Espressione argomento;
	/**
	 * stampera una stringa
	 * @param e il valore di una stringa da stampare
	 */
	public Print(String e) {
		this(new Stringa(e));
	}
	/**
	 * stamperà un espressione
	 * @param e il valore espressione da stamoare
	 */
	public Print(Espressione e) {
		argomento = e;
	}
	/**
	 * stamperà una intero
	 * @param e un intero da stampare
	 */
	public Print(int e) {
		this(new Intero(e));
	}
	/**
	 * stamperà una booleano
	 * @param e valore booleano da stampare
	 */
	public Print(boolean e) {
		this(new Booleano(e));
	}
	/**
	 * stampera a video un istruzione
	 */
	public void esegui() {
		System.out.println((argomento.getValore()));
	}



}
