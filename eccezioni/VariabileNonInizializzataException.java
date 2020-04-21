package eccezioni;

public class VariabileNonInizializzataException extends Exception{
	public VariabileNonInizializzataException(String var) {
		super("variabile ancora inizializzata: "+var);
	}
}
