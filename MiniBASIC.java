package primo;

import primo.Variabile.Nome;

public class MiniBASIC {
	public static void main(String[] args) {
	Variabile v1 = new Variabile(Nome.$0,"2");
	Variabile v2 = new Variabile(Nome.$1,"2");
	Costante c1 = new Costante(true);
	try {
	EspressioneComposta c = new EspressioneComposta(v1,c1);
	System.out.println(c.getValore());
	}
	catch(TipiIncopatibiliException e) {System.out.print(e);}
	}
	

}
