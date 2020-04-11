package primo;

import primo.Espressione.Tipo;

public class Variabile extends Espressione {
	private Nome nome;
	private String valore;
	private int maxVariabili =Nome.values().length;
	private static int numeroVariabili; // mi servira nel mini basic per limitar eil numero dell variabili
	
	enum Nome{
		$0,$1,$2,$3,$4,$5,$6,$7,$8,$9
	}
	
	public Variabile(Nome nome,String valore) {
		super(valore);
		this.nome = nome;
		this.valore = valore;
		numeroVariabili++;
	}
	
	public Variabile(Nome nome,int valore) {
		this(nome,""+valore);
	}
	
	public Variabile(Nome nome,boolean valore) {
		this(nome,""+valore);
	}
	@Override
	public Object getValore() {
		if(this.tipo==Tipo.INTERO) return Integer.parseInt(valore);
		if(this.tipo==Tipo.BOOLEANO) return this.valore.equals("true")?  true: false;
		return valore;
	}
	
	public int getMaxVariabili() {return maxVariabili;}
	public int getNumeroVariabili() {return numeroVariabili;}

}
