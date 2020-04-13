package espressioni;
import espressioni.Espressione.Tipo;

public class Stringa extends Costante{
	/**
	 * valore della costante
	 */
	 private String VALORE;
	
	/**
	 * costruttore,assegna il valore e con il costruttore della superclasse, il tipo
	 * @param valore della costante
	 */	 
	 public Stringa(String valore) {
		super(Tipo.STRINGA);
		this.VALORE = valore;
	}
	
	/**
	 * @return il valore della costante
	 */
	@Override
	public Object getValore() {
		return VALORE;
	}

}
