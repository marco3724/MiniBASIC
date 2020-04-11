package primo;

import primo.Espressione.Tipo;

public class EspressioneSomma extends EspressioneComposta{
	
	private String valore;
	
	public EspressioneSomma(Espressione... espressione) throws TipiIncopatibiliException {
		super(espressione);
		somma();
	}
	private void somma() {
		valore = switch(tipo) {
		case INTERO-> ""+sommaInteri();
		case BOOLEANO-> ""+sommaBooleani();
		case STRINGA-> sommaStringhe();
		};
	}
	private int sommaInteri() {
		int s = 0;
		for(int i = 0;i<espressione.length;i++) {
			s += (int)espressione[i].getValore();
		}
		return s;
	}
	
	private boolean sommaBooleani() {
		int s = 0;
		for(int i = 0;i<espressione.length;i++) {
			if(espressione[i].getValore().equals("true")) return true;
		}
		return false;
	}
	
	private String sommaStringhe() {
		String s = "";
		for(int i = 0;i<espressione.length;i++) {
			s += (String)espressione[i].getValore();
		}
		return s;
	}

	@Override
	Object getValore() {
		
		return valore;
	}
	

}
