package istruzioni;
/**
 * classe che definisce l'istruzione commento
 * serve principalemente per il metodo statico of di programma
 * @author marco
 *
 */
public class Commento implements Istruzione {
	private String commento;
	public Commento(String commento) {
		this.commento = commento;
	}
	@Override
	public void esegui() {
	}

}
