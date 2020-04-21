package eccezioni;
/**
 * quest'eccezione serve per avvertire l'utente che ha inserito due espressioni non copatibili per la somma/concatenazione
 * @author marco
 *
 */
public class TipiIncopamtibiliException extends Exception {
	public TipiIncopamtibiliException() {
		super("tipi incompatibili");
	}

}
