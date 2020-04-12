package primo;

import primo.Espressione.Tipo;
/**
 * Classe variabile serve a creare un oggetto di tipo variabile che avr� un valore e in base al tipo di valore gli verr� assegnato il tipo
 * il valore potr� essere cambiato in futuro
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
	private int maxVariabili =Nome.values().length;
	/**
	 * questo campo serve per contare il numero delle instanze create
	 */
	private static int numeroVariabili; // mi servira nel mini basic per limitar eil numero dell variabili
	
	/**
	 * tutti i possibili nomi delle variabili
	 * @author marco
	 *
	 */
	enum Nome{
		$0,$1,$2,$3,$4,$5,$6,$7,$8,$9
	}
	/**
	 * costruttore di questa classe,
	 * assegna i valori nome e valori
	 * passer� il valore alla superclasse per definire il suo tipo
	 * incrementa il contatore del numero delle variabili create
	 * @param nome = nome della variabile
	 * @param valore = valore della variabile
	 */
	public Variabile(Nome nome,String valore) {
		super(valore);
		this.nome = nome;
		this.valore = valore;
		numeroVariabili++;
	}
	
	public Variabile(Nome nome,int valore) {
		this(nome,""+valore);
	}
	
	public Variabile(Nome nome,boolean valore) {
		this(nome,""+valore);
	}
	/**
	 * assegna un nuovo valore alla variabile
	 * @param valore � il nuovo valore della variabile che per� deve essere compatibile con la vecchia variabile
	 */
	public void setValore(String valore) throws TipiIncopatibiliException{
		if(this.getTipo()!=super.returnTipo(valore)) throw new TipiIncopatibiliException();
		this.valore = valore;
		
	}
	public void setValore(int valore) throws TipiIncopatibiliException {
		setValore(""+valore);
		
	}
	public void setValore(boolean valore) throws TipiIncopatibiliException{
		setValore(""+valore);
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
	public int getMaxVariabili() {return maxVariabili;}
	/**
	 * 
	 * @return resituisce il numero di variabili create
	 */
	public int getNumeroVariabili() {return numeroVariabili;}

}
