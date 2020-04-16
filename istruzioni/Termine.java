package istruzioni;

public class Termine implements Istruzione{
	private boolean terminato;
	public Termine() {
		terminato = false;
	}
	@Override
	public void esegui() {
		terminato =true;
	}
	public boolean getValore() {
		return terminato;
	}
	


}
