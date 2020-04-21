package istruzioni;

import it.uniroma1.metodologie.Programma;
/**
 * utilizza un etichetta per saltare dall'istruzione corrente alla poszione dell'estichetta
 * @author marco
 *
 */
public class Salto implements Istruzione{
	private Etichetta etichetta;
	//public Programma programma;
	public Salto(Etichetta etichetta) {
		this.etichetta = etichetta;
		//this.programma = programma;
	}
	/**
	 * la sua esecuzione viene effettuata direttamente nell'iteratore
	 */
	@Override
	public void esegui() {
		//programma.setGoTo(true);
		//programma.setWhere(etichetta.getPosizione());

	}
	public Etichetta getEtichetta() {
		return etichetta;
	}
	

}
