package eccezioni;
/**
 * questo err
 * @author marco
 *
 */
public class NumeroMassimoVariabiliSuperatoException extends Exception{
	public NumeroMassimoVariabiliSuperatoException(int numero) {
		super("il massimo numero di variabili disponibili è: "+""+numero);
	}

}
