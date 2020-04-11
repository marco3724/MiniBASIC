package primo;

public class Costante implements Espressione{
	private final String valore;
	private final Tipo tipo;
	public Costante(String v) {
		valore = v;
	}
	
	@Override
	public String getValore() {
		return valore;
	}
	
	@Override
	public Tipo getTipo() {
		return tipo;
	}

}
