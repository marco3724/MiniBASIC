package primo;

import primo.Espressione.Tipo;
/**
 * classe dedicata alla somma di espressioni
 * @author marco
 *
 */
public class EspressioneSomma extends EspressioneComposta{
	/**
	 * valore della somma/concatenazione
	 */
	private String valore;
	/**
	 * dopo aver create l'espressione col super costruttore li sommo/concateno
	 * @param espressione insieme di espressioni da sommare
	 * @throws TipiIncopatibiliException se non sono tutti dello stesso tipo viene lanciato un errore
	 */
	public EspressioneSomma(Espressione... espressione) throws TipiIncopatibiliException {
		super(espressione);
		somma();
	}
	/**
	 * somma in base al tipo
	 */
	private void somma() {
		valore = switch(this.getTipo()) {
		case INTERO-> ""+sommaInteri();
		case BOOLEANO-> ""+sommaBooleani();
		case STRINGA-> concatena();
		};
	}
	/**
	 * viene effetuata una somma aritmetica
	 * @return la somma
	 */
	private int sommaInteri() {
		int s = 0;
		for(int i = 0;i<super.getEspressione().length;i++) {
			s += (int)super.getEspressione()[i].getValore();
		}
		return s;
	}
	/**
	 * viene effettuata l'or fra le espressioni , quindi basta un true per far si che il valore sia true
	 * @return somma logica 
	 */
	private boolean sommaBooleani() {
		int s = 0;
		for(int i = 0;i<super.getEspressione().length;i++) {
			if(super.getEspressione()[i].getValore().equals("true")) return true;
		}
		return false;
	}
	/**
	 * viene effettuata la concatenazione delle stringhe
	 * @return la stringa concatenata
	 */
	private String concatena() {
		String s = "";
		for(int i = 0;i<super.getEspressione().length;i++) {
			s += (String)super.getEspressione()[i].getValore();
		}
		return s;
	}
	/**
	 * @return il valore dell'espressione sommata
	 */
	@Override
	public Object getValore() {
		
		return valore;
	}
	

}
