package istruzioni;

public class Salto implements Istruzione{
	Etichetta etichetta;
	public Salto(Etichetta etichetta) {
		this.etichetta = etichetta;
	}
	@Override
	public void esegui() {
		System.out.println(etichetta.getNome()+etichetta.getPosizione());
	}
	

}
