package espressioni;
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
	public enum Tipo {
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
	 * serve a valutare il tipo di un'espressione
	 * @param valore = valore da valutare
	 * @return restituisce il tipo dell'espressione
	 */
	public static Tipo returnTipo(String valore) {
		if(valore.charAt(0)=='"' && valore.charAt(valore.length()-1)=='"') return Tipo.STRINGA;
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
	public abstract Object getValore();
	

}


