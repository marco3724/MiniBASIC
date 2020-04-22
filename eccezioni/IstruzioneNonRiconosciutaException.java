package eccezioni;
/**
 * istruzione non riconosciuta
 * @author marco
 *
 */
public class IstruzioneNonRiconosciutaException extends Exception{
	public IstruzioneNonRiconosciutaException(String istruzione) {
		super("l'istruzione non riconosciuta: "+istruzione);
	}
}
