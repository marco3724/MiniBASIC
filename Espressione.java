package primo;

abstract public class Espressione {
	protected Tipo tipo;
	enum Tipo {
		INTERO,STRINGA,BOOLEANO;
	}
	
	public Espressione(String valore) {
		if(valore.charAt(0)=='"' && valore.charAt(valore.length()-1)=='"') {
			this.tipo = Tipo.STRINGA;	
		}
		else if(valore=="true" || valore =="false") {
			this.tipo = Tipo.BOOLEANO;	
		}
		else {
		this.tipo = Tipo.INTERO;	
		}
	}
	
	public Tipo getTipo() {return tipo;}
	abstract Object getValore();
	

}


