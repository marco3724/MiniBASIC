package eccezioni;
/**
 * quest'eccezione serve per avvertire l'utente che non ha ancora inzializzato la variabile
 * es. $0 = $0 + 1 ----> dovrebbe essere $0 = 0; $0 = $0 + 1;
 * 
 * @author marco
 *
 */
public class VariabileNonInizializzataException extends Exception{
	public VariabileNonInizializzataException(String var) {
		super("variabile ancora inizializzata: "+var);
	}
}
