package istruzioni;

import it.uniroma1.metodologie.Programma;

public class Salto implements Istruzione{
	public Etichetta etichetta;
	public Programma programma;
	public Salto(Etichetta etichetta) {
		this.etichetta = etichetta;
		this.programma = programma;
	}
	@Override
	public void esegui() {
		//programma.setGoTo(true);
		//programma.setWhere(etichetta.getPosizione());

	}
	

}
