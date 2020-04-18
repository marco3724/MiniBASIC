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
	

}
