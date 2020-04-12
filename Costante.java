package primo;
/**
 * questa classe serve a instanziare un valore immutabile
 * @author uni
 *
 */
public class Costante extends Espressione{
	/**
	 * valore della costante
	 */
	private final String valore;
	/**
	 * costruttore,assegna il valore ed  il tipo
	 * @param valore della costante
	 */
	public Costante(String valore) {
		super(valore);
		this.valore = valore;
	}
	public Costante(int valore) {
		this(""+valore);
	}
	public Costante(boolean valore) {
		this(""+valore);
	}
	
	/**
	 * @return il valore della costante
	 */
	@Override
	public Object getValore() {
		if(this.getTipo()==Tipo.INTERO) return Integer.parseInt(valore);
		if(this.getTipo()==Tipo.BOOLEANO) return this.valore.equals("true")?  true: false;
		return valore;
	}

}
