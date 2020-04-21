package istruzioni;
/**
 * ogni programma ha un instanza di termine che funge da flag che deciderà se l'esecuzione di un programma termina o no
 * @author marco
 *
 */
public class Termine implements Istruzione{
	private boolean terminato = false;
	@Override
	/**
	 * cambia il flag in true e terminera il prgramma
	 */
	public void esegui() {
		terminato = true;
	}
	/**
	 * 
	 * @return lo stato del flag
	 */
	public boolean getTermine() {
		return terminato;
	}

	


}
