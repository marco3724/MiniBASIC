package primo;

public class Variabile extends Espressione {
	Nome nome;
	String valore;
	private static int max = 10;
	enum Nome{
		$0,$1,$2,$3,$4,$5,$6,$7,$8,$9
	}
	public Variabile(Nome nome,String valore) {
		super(valore);
		this.nome = nome;
		this.valore = valore;
	}

}
