package eccezioni;
/**
 * quest'eccezione serve per avvertire l'utente che ha inserito un opratore invalido
 * @author marco
 *
 */
public class OperatoreNonTrovatoException extends Exception{
	public OperatoreNonTrovatoException(String simbolo) {
		super("operatore non trovato "+'"'+simbolo+'"');
	}
	

}
