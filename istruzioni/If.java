package istruzioni;

import espressioni.EspressioneConfronto;
/**
 * struttura della Selezione e del whileDo:
 * se la condizione è vera esegue istruzioni
 * @author marco
 *
 */
public class If implements Istruzione{
	protected EspressioneConfronto argomento;
	protected Istruzione[] istruzioni;
	/**
	 * 
	 * @param e = espressione di confronto
	 * @param istruzioni= istruzioni da eseguire se vero
	 */
	public If(EspressioneConfronto e,Istruzione... istruzioni) {
		argomento = e;
		this.istruzioni = istruzioni;
	}
	
	/**
	 * esegue le istruzioni se è di tipo Termine termina immediatamente anche se ci sono istruzioni a seguire
	 * però prima deve eseguirlo(l'struzione di termine) in quanto deve settare il flag di termine del programma in true
	 */
	@Override
	public void esegui() {
		for(Istruzione i: istruzioni) {
			i.esegui();
			if(i instanceof Termine) break;
		}	
	}
}