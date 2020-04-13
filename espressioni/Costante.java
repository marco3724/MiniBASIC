package espressioni;
/**
 * questa classe serve a instanziare un valore immutabile
 * @author uni
 *
 */
abstract public class Costante extends Espressione{
	/**
	 * costruttore,assegna  il tipo
	 * @param tipo della costante
	 */
	public Costante(Tipo tipo) {
		super(tipo);
	}

}
