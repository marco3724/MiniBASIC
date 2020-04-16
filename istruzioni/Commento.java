package istruzioni;

public class Commento implements Istruzione {
	private String commento;
	public Commento(String commento) {
		this.commento = commento;
	}
	@Override
	public void esegui() {
		
	}

}
