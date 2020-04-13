package istruzioni;

import espressioni.Espressione;

public class Print implements Istruzione {
	
	public void esegui(Espressione e) {
		System.out.println(e.getValore());
	}



}
