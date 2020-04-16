package istruzioni;

import espressioni.EspressioneConfronto;
import it.uniroma1.metodologie.Programma;

public class Selezione implements Istruzione{
	private If se;
	private Else altrimenti;
	
	public Selezione(EspressioneConfronto e,Istruzione[] seIstruzioni,Istruzione... altrimentiIstruzioni) {
		se = new If(e,seIstruzioni);
		altrimenti = new Else(altrimentiIstruzioni);
	}
	@Override
	public void esegui() {
		if((boolean)se.argomento.getValore()) {
			se.esegui();
		}
		else {
			altrimenti.esegui();
		}
	}
}

 class If implements Istruzione{
	protected EspressioneConfronto argomento;
	protected Istruzione[] istruzioni;
	public If(EspressioneConfronto e,Istruzione... istruzioni) {
		argomento = e;
		this.istruzioni = istruzioni;
	}
	@Override
	public void esegui() {
		for(Istruzione i: istruzioni) {
			i.esegui();
		}	
	}
}
 
 class Else implements Istruzione{
	 protected Istruzione[] istruzioni;
		public Else(Istruzione... istruzioni) {
			this.istruzioni = istruzioni;
		}
		@Override
		public void esegui() {
			for(Istruzione i : istruzioni) {
				i.esegui();
			}		
		}
	}

