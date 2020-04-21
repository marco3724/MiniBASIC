package espressioni;
/**
 * questa classe serve a instanziare un valore immutabile, infatti non ha un metodo setCostante
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
	/**
	 * crea un instanza di una costante
	 * se è una strimga togliera le parentesi
	 * @param valore della costante
	 * @return ritorna un'instanza di una sottoclasse di costante (Intero,Stringa,Booleano)
	 */
	public static Costante of(String valore) {
		return switch(returnTipo(valore)) {
		case BOOLEANO -> new Booleano(Boolean.getBoolean(valore));
		case STRINGA -> new Stringa(valore.substring(1,valore.length()-1));
		case INTERO -> new Intero(Integer.parseInt(valore));
		};
	}

}
