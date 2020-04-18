package istruzioni;

import espressioni.Booleano;
import espressioni.Espressione;
import espressioni.Intero;
import espressioni.Stringa;

public class Print implements Istruzione {
	private Espressione argomento;
	
	public Print(String e) {
		this(new Stringa(e));
	}
	public Print(Espressione e) {
		argomento = e;
	}
	public Print(int e) {
		this(new Intero(e));
	}
	public Print(boolean e) {
		this(new Booleano(e));
	}

	public void esegui() {
		System.out.println(argomento.getValore()+" "+argomento);
	}



}
