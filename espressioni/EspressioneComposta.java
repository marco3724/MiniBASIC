package espressioni;

import espressioni.Espressione.Tipo;
/**
 * superclasse di EspressioneConfronto e EspressioneSomma 
 * @author uni
 *
 */
abstract public class EspressioneComposta extends Espressione{
	/**
	 * array di espressioni che compongono l'espressione
	 */
	private Espressione[] espressione;
	/**
	 * viene assegnato il tipo tramite la sua superclasse
	 * i valori tramite il parametro
	 * @param e1 valori che compongono l'espressione
	 * @throws TipiIncopamtibiliException devono essre tutti dello stesso tipo,altrimenti viene lanciato un errore
	 */
	public EspressioneComposta(Espressione... e1) throws TipiIncopamtibiliException{
		super(e1[0].getTipo());
		if(!sonoDelloStessoTipo(e1)) throw new TipiIncopamtibiliException();
		espressione = e1;
	}
	public EspressioneComposta(Tipo tipo,Espressione... e1) throws TipiIncopamtibiliException{
		super(tipo);
		if(!sonoDelloStessoTipo(e1)) throw new TipiIncopamtibiliException();
		espressione = e1;
	}
	
	/**
	 * 
	 * @return un booleano che indica se sono dello stesso tipo
	 */
	private boolean sonoDelloStessoTipo(Espressione... e1) {
		Tipo tipo = e1[0].getTipo();
		for(int i = 1;i<e1.length;i++) {
			if(tipo!=e1[i].getTipo()) return false;
		}
		return true;
	}
	/**
	 * 
	 * @return restituisce l'espressione composta
	 */
	public Espressione[] getEspressione() {
		return this.espressione;
	}
}
