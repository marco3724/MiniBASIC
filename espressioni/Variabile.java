package espressioni;

import eccezioni.NumeroMassimoVariabiliSuperatoException;
import eccezioni.TipiIncopamtibiliException;
import espressioni.Espressione.Tipo;
/**
 * Classe variabile serve a creare un oggetto di tipo variabile che avrà un valore e in base al tipo di valore gli verrà assegnato il tipo
 * il valore potrà essere cambiato in futuro
 * @author marco
 * @see Espressione
 *
 */
public class Variabile extends Espressione {
	private Nome nome;
	private String valore;
	/**
	 * numero massimo di variabili che si possono instanziare 
	 */
	private static int maxVariabili = Nome.values().length;
	/**
	 * questo campo serve per contare il numero delle instanze create
	 */
	private static int numeroVariabili; // mi servira nel mini basic per limitar eil numero dell variabili
	
	/**
	 * tutti i possibili nomi delle variabili
	 * @author marco
	 *
	 */
	public enum Nome{
		$0,$1,$2,$3,$4,$5,$6,$7,$8,$9;
	}
	/**
	 * costruttore di questa classe,
	 * assegna i valori nome e valori
	 * passerà il valore alla superclasse per definire il suo tipo
	 * incrementa il contatore del numero delle variabili create
	 * @param nome = nome della variabile
	 * @param valore = valore della variabile
	 * @throws NumeroMassimoVariabiliSuperatoException se si creano troppe variabili verrà lanciata questa eccezione
	 */
	public Variabile(Nome nome,String valore) throws NumeroMassimoVariabiliSuperatoException {
		super(valore);
		if(numeroVariabili>=maxVariabili) throw new NumeroMassimoVariabiliSuperatoException(maxVariabili);
		this.nome = nome;
		if(valore.charAt(0) == '"' && valore.charAt(valore.length()-1) == '"') this.valore = valore.substring(1,valore.length()-1);
		else this.valore = valore;
		numeroVariabili++;
	}
	
	public Variabile(Nome nome,int valore) throws NumeroMassimoVariabiliSuperatoException {
		this(nome,""+valore);
	}
	
	public Variabile(Nome nome,boolean valore) throws NumeroMassimoVariabiliSuperatoException {
		this(nome,""+valore);
	}
	/**
	 * serve ad inzializzare la variabile in base al tipo
	 * @param nome
	 * @param tipo
	 */
	public Variabile(Nome nome,Tipo tipo) {
		super(tipo);
		this.valore = switch(tipo) {
		case INTERO-> "0";
		case BOOLEANO-> "true";
		case STRINGA-> "";
		};
		
		this.nome = nome;
	}
	/**
	 * assegna un nuovo valore alla variabile
	 * @param valore è il nuovo valore della variabile che però deve essere compatibile con la vecchia variabile
	 */
	public void setValore(String valore) {
		
		this.valore = valore;
	
		
	}
	public void setValore(int valore)  {
		setValore(""+valore);
		
	}
	public void setValore(boolean valore) {
		setValore(""+valore);
	}
	public void setValore(Variabile valore) {
		setValore(""+valore.getValore());
	}
	/**
	 * ritorna il valore in base al suo tipo
	 */
	@Override
	public Object getValore() {
		if(this.getTipo()==Tipo.INTERO) return Integer.parseInt(valore);
		if(this.getTipo()==Tipo.BOOLEANO) return this.valore.equals("true")?  true: false;
		return valore;
	}
	/**
	 * 
	 * @return restituisce il massimo numero di variabili che si possono creare
	 */
	public static int getMaxVariabili() {return maxVariabili;}
	/**
	 * 
	 * @return resituisce il numero di variabili create
	 */
	public static int getNumeroVariabili() {return numeroVariabili;}
	
	@Override
	public String toString(){ return super.toString()+"  "+this.nome+"";}

}
