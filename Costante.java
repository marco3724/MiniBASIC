package primo;

public class Costante extends Espressione{
	private final String valore;
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
	
	@Override
	public Object getValore() {
		if(this.tipo==Tipo.INTERO) return Integer.parseInt(valore);
		if(this.tipo==Tipo.BOOLEANO) return this.valore.equals("true")?  true: false;
		return valore;
	}

}
