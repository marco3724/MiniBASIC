package istruzioni;

import espressioni.EspressioneConfronto;
import it.uniroma1.metodologie.Programma;
/**
 * è composta da due strutture un if ed un else 
 * if--> condizione,istruzioni
 * else--> istruzioni
 * se la condizione è vera esgue le istruzioni presenti nell'if
 * altrimente eseguire le istruzioni presenti nell'else
 * @author marco
 *
 */
public class Selezione implements Istruzione{
	private If se;
	private Else altrimenti;
	/**
	 * prende un espressione e istruzioni
	 * @param e condizione(espreessione booleana)
	 * @param seIstruzioni istruzioni che veranno eseguite se la condizione è vera
	 * @param altrimentiIstruzioni istruzioni che veraanno eseguite se la condizione è falsa
	 */
	public Selezione(EspressioneConfronto e,Istruzione[] seIstruzioni,Istruzione... altrimentiIstruzioni) {
		se = new If(e,seIstruzioni);
		altrimenti = new Else(altrimentiIstruzioni);
	}
	/**
	 * 
	 * @param ist prende un if che è composta da condizione e istruzioni
	 * @param altrimentiIstruzioni prende un insieme di istruzioni
	 */
	public Selezione(If ist,Istruzione... altrimentiIstruzioni) {
		se = ist;
		altrimenti = new Else(altrimentiIstruzioni);
	}
	@Override
	/**
	 * se la condizione è vera esegue l'istruzione contenuto nell'if, altrimenti esegue le istruzioni nell'else
	 */
	public void esegui() {
		if((boolean)se.argomento.getValore()) {
			se.esegui();
		}
		else {
			altrimenti.esegui();
		}
	}
	
	 private class Else implements Istruzione{
		 protected Istruzione[] istruzioni;
			public Else(Istruzione... istruzioni) {
				this.istruzioni = istruzioni;
			}
			@Override
			public void esegui() {
				for(Istruzione i : istruzioni) {
					i.esegui();
					if(i instanceof Termine) break;
				}		
			}
		}
}

 


