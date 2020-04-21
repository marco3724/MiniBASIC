package espressioni;

import espressioni.Espressione.Tipo;
/**
 * classe che denifinisce un booleano
 * @author marco
 *
 */
public class Booleano extends Costante{
	/**
	 * valore della costante
	 */
	private boolean VALORE;
	
	/**
	 * costruttore,assegna il valore e con il costruttore della superclasse, il tipo
	 * @param valore della costante
	 */
	public Booleano(boolean valore) {
		super(Tipo.BOOLEANO);
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
