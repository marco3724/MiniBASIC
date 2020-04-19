package istruzioni;

public class Etichetta implements Istruzione{
	private String nome;
	private int posizione;
	public Etichetta(String nome,int posizione) 
	{
		this.nome = nome;
		this.posizione = posizione;
	}
	@Override
	public void esegui() {
	}
	public String getNome() {
		return nome;
	}
	public void setPosizione(int pos) {
		posizione = pos;
	}
	public int getPosizione() {
		return posizione;
	}
	

}
