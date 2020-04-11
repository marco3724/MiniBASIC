package primo;

/**
 * variabili predefinite
 * @author marco
 *
 */
public enum Variabile implements Espressione{
	$0,$1,$2,$3,$4,$5,$6,$7,$8,$9;
	private String valore;
	private Tipo tipo;
	
	/**
	 * assegno il valore e il tipo
	 * @param valore = valore della variabile
	 */
	public void setValore(String valore) {
		this.valore = valore;
		setTipo(valore);
	}
	
	/**
	 * serve a definire il tipo
	 */
	private void setTipo(String valore) {
		if(valore.charAt(0)=='"' && valore.charAt(valore.length()-1)=='"') {
			this.tipo = Tipo.STRINGA;	
		}
		else if(valore=="true" || valore =="false") {
			this.tipo = Tipo.BOOLEANO;	
		}
		else {
		this.tipo = Tipo.INTERO;	
		}
	}

	@Override
	public Object getValore() {
		System.out.println(this);
		if(this.tipo==Tipo.INTERO) return Integer.parseInt(valore);
		if(this.tipo==Tipo.BOOLEANO) return this.valore=="true"?  true: false;
		return valore;
	}
	
	@Override
	public Tipo getTipo() {
		return this.tipo;
	}
	
	
	@Override
	public String toString() {
		
		return super.toString()+" "+valore+" "+tipo;
	}

}
//uso le enum cosi quandoo vado ad prendere i dati es. incontro $3 faccio
//variabili.valuesof($3).valore ecc
// se invece uso una classe variabile c = variaile(nome.valueof($3),valore,Tipo)
// se devo cambiare una variabile valuesof(x).valore ecc         x = nome della variabile
//classi: dovrei sapere il nome della variabile e x è diverso da c mentre nell enume il valore della c è la variabile stessa
//vince enum