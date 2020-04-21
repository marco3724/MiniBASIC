package istruzioni;

public class Termine implements Istruzione{
	private boolean terminato = false;
	@Override
	public void esegui() {
		terminato = true;
	}
	public boolean getTermine() {
		return terminato;
	}

	


}
