package primo;
import java.lang.NumberFormatException;

abstract public class Espressione {
	protected Tipo tipo;
	enum Tipo {
		INTERO,STRINGA,BOOLEANO;
	}
	
	public Espressione(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Espressione(String valore)  {

		if(valore.equals("true") || valore.equals("false")) 
			this.tipo = Tipo.BOOLEANO;	
		
		else if(true) { 
			try {
				Integer.parseInt(valore);
				this.tipo = Tipo.INTERO;	
			}
			catch(NumberFormatException e){this.tipo = Tipo.STRINGA;}
		}
		
		
	}
	
	public Tipo getTipo() {return tipo;}
	abstract Object getValore();
	

}


