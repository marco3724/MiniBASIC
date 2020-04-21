package eccezioni;

public class OperatoreNonTrovatoException extends Exception{
	public OperatoreNonTrovatoException(String simbolo) {
		super("operatore non trovato "+'"'+simbolo+'"');
	}
	

}
