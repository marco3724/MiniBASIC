package istruzioni;

import espressioni.Espressione;

public class Print implements Istruzione {
	private String argomento;
	
	public Print(String e) {
		argomento = e;
	}
	public Print(Espressione e) {
		this(""+e.getValore());
	}
	public Print(int e) {
		this(""+e);
	}
	public Print(boolean e) {
		this(""+e);
	}

	public void esegui() {
		System.out.println(argomento);
	}



}
