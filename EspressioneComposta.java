package primo;

public class EspressioneComposta extends Espressione{
	Espressione e1;
	Espressione e2;
	private String valore;

	public EspressioneComposta(Espressione e1,Espressione e2) throws TipiIncopatibiliException{
		super(e1.tipo);
		if(e1.tipo!=e2.tipo) throw new TipiIncopatibiliException();
		this.e1 = e1;
		this.e2 = e2;
		somma();
	}
	private void somma() {
		valore = switch(tipo) {
		case INTERO-> ""+((int)e1.getValore()+(int)e2.getValore());
		case BOOLEANO-> ""+((boolean)e1.getValore() || (boolean)e2.getValore());
		case STRINGA-> (String)e1.getValore() +(String)e2.getValore();
		};
	}
	@Override
	Object getValore() {
		
		return valore;
	}

}
