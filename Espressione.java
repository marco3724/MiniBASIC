package primo;

public class Espressione {
	protected Tipo tipo;
	enum Tipo {
		INTERO,STRINGA,BOOLEANO;
	}
	public Espressione(Tipo t) {
		tipo = t;
	}
	

}
