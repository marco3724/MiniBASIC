package istruzioni;

import espressioni.EspressioneConfronto;

public class Iterazione implements Istruzione {
	private If whileDo;
	public Iterazione(EspressioneConfronto e,Istruzione... i) {
		whileDo = new If(e,i);
	}
	public Iterazione(If e) {
		whileDo = e;
	}
	@Override
	public void esegui() {
		while((boolean)whileDo.argomento.getValore()) {
			for(Istruzione i : whileDo.istruzioni) {
				i.esegui();
			}
		}
		
	}
	

}
