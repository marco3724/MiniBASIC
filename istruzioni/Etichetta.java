package istruzioni;
/**
 * questa classe serve per creare un  etichetta che ha un nome e la posizione della prossima istruzione da eseguire
 * @author marco
 *
 */
public class Etichetta implements Istruzione{
	private String nome;
	private int posizione;
	/**
	 * costruttore di Etichetta
	 * @param nome
	 * @param posizione della prossima istruzione
	 */
	public Etichetta(String nome,int posizione) 
	{
		this.nome = nome;
		this.posizione = posizione;
	}
	@Override
	public void esegui() {
	}
	/**
	 * 
	 * @return nome dell'etichetta
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * imposta la posizione
	 * @param pos
	 */
	public void setPosizione(int pos) {
		posizione = pos;
	}
	/**
	 * resituisce la posizione
	 * @return la posizione
	 */
	public int getPosizione() {
		return posizione;
	}
	

}
