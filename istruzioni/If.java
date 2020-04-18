package istruzioni;

import espressioni.EspressioneConfronto;

public class If implements Istruzione{
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