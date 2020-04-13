package espressioni;

import espressioni.Espressione.Tipo;

public class Intero extends Costante{
	/**
	 * valore della costante 
	 */
	private final int VALORE;
	
	/**
	 * costruttore,assegna il valore e con il costruttore della superclasse, il tipo
	 * @param valore della costante
	 */
	public Intero(int valore) {
		super(Tipo.INTERO);
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
