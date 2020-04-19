package istruzioni;

import espressioni.Booleano;
import espressioni.Espressione;
import espressioni.Espressione.Tipo;
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
		if(argomento.getTipo()==Tipo.STRINGA) {
			if((""+argomento.getValore()).charAt(0) == '"' && (""+argomento.getValore()).charAt((""+argomento.getValore()).length()-1) == '"' ) 
				System.out.println(((""+argomento.getValore()).substring(1, (""+argomento.getValore()).length()-1)));
			else System.out.println((argomento.getValore()));
		}
		else System.out.println((argomento.getValore()));
	}



}
