package istruzioni;

import espressioni.EspressioneConfronto;
/**
 * classe che definisce il whileDo utilizza la stessa struttura che usa la Selezione
 * la sua esecuzione consiste nel confrontare un espressione booleana e se vera esegue le istruzioni
 * @author marco
 *
 */
public class Iterazione implements Istruzione {
	private If whileDo;
	/**
	 * costruttore per il while
	 * @param e l'espressione di confronto
	 * @param i le istruzione da eseguere se la condizione è vera
	 */
	public Iterazione(EspressioneConfronto e,Istruzione... i) {
		whileDo = new If(e,i);
	}
	/**
	 * puo essere costruita anche con un oggetto If
	 * @param e
	 */
	public Iterazione(If e) {
		whileDo = e;
	}
	@Override
	/**
	 * se la condizione è vera itera le istruzioni
	 */
	public void esegui() {
		while((boolean)whileDo.argomento.getValore()) {
			for(Istruzione i : whileDo.istruzioni) {
				i.esegui();
			}
		}
		
	}
	

}
