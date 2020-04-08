package primo;

public enum Variabile {
	$0,$1,$2,$3,$4,$5,$6,$7,$8,$9;
	String valore;
	Tipo tipo;
	enum Tipo{
		BOOLEANO,INTERO,STRINGA;
	}

}
//uso le enum cosi quandoo vado ad prendere i dati es. incontro $3 faccio
//variabili.valuesof($3).valore ecc
// se invece uso una classe variabile c = variaile(nome.valueof($3),valore,Tipo)
// se devo cambiare una variabile valuesof(x).valore ecc         x = nome della variabile
//classi: dovrei sapere il nome della variabile e x è diverso da c mentre nell enume il valore della c è la variabile stessa
//vince enum