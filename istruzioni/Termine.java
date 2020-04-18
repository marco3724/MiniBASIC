package istruzioni;

public class Termine implements Istruzione{
	private boolean terminato;
	public Termine() {
		terminato = false;
	}
	@Override
	public void esegui() {
		System.exit(1);
	}
	public boolean getValore() {
		return terminato;
	}
	


}
