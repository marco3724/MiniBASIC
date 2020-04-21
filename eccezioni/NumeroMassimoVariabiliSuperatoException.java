package eccezioni;
/**
 * questo eccezione serve quando creo troppe variabili, se un programma viene creato  attraverso il metodo fromFile non serve in quanto li c'è un vettore di variabili
 * @author marco
 *
 */
public class NumeroMassimoVariabiliSuperatoException extends Exception{
	public NumeroMassimoVariabiliSuperatoException(int numero) {
		super("il massimo numero di variabili disponibili è: "+""+numero);
	}

}
