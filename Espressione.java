package primo;
import java.lang.NumberFormatException;
/**
 * superclasse di variabile,costante,espressione composta
 * definisce solo un campo : il tipo
 * @author marco
 *
 */
abstract public class Espressione {
	/**
	 * tipo dell'espressione che non potrà mai più essere modificata una volta assegnata
	 */
	private Tipo tipo;
	/**
	 * i tipi sono predefiniti
	 * @author marco
	 *
	 */
	enum Tipo {
		INTERO,STRINGA,BOOLEANO;
	}
	/**
	 * costruttore che prende il tipo
	 * @param tipo = tipo dell'espressione
	 */
	public Espressione(Tipo tipo) {
		this.tipo = tipo;
	}
	/**
	 * costruttore che prende il valore e assegna il tipo corrispondente
	 * @param valore in base a questo valore viene assegnato un tipo
	 */
	public Espressione(String valore)  {
		tipo = returnTipo(valore);
	}
	
	/**
	 * 
	 * @param valore = valore da valutare
	 * @return restituisce il tipo dell'espressione
	 */
	protected Tipo returnTipo(String valore) {
		if(valore.equals("true") || valore.equals("false")) 
			return Tipo.BOOLEANO;	
		
		else { 
			try {
				Integer.parseInt(valore);
				return Tipo.INTERO;	
			}
			catch(NumberFormatException e){
				return Tipo.STRINGA;
			}
		}
	}
	
	/**
	 * 
	 * @return il tipo dell'oggetto
	 */
	public Tipo getTipo() {return tipo;}
	abstract Object getValore();
	

}


