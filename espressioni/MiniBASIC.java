 package espressioni;

import eccezioni.TipiIncopamtibiliException;
import espressioni.EspressioneConfronto.Operatore;
import espressioni.Variabile.Nome;

public class MiniBASIC {
	public static void main(String[] args) {
	Variabile v1 = new Variabile(Nome.$0,"2");
	Variabile v2 = new Variabile(Nome.$1,"2");
	Costante c1 = new Intero(2);
	try {
	EspressioneSomma c = new EspressioneSomma(v1,c1,new Intero(6),v2);
	System.out.println(c.getValore()+"  "+c.getTipo());
	EspressioneConfronto c2 = new EspressioneConfronto(v1, v2, Operatore.UGUALE);
	EspressioneConfronto c3 = new EspressioneConfronto(v1, v2, Operatore.MAGGIORE);
	EspressioneConfronto c4 = new EspressioneConfronto(v2, v1, Operatore.MAGGIORE);
	EspressioneConfronto c5 = new EspressioneConfronto(v2, v1, Operatore.MAGGIORE_UGUALE);
	//EspressioneConfronto c6 = new EspressioneConfronto(new Costante("CIAO"), new Costante(2), Operatore.MAGGIORE_UGUALE);
	//EspressioneConfronto c7 = new EspressioneConfronto(new Costante("CIAO"), new Costante("ciao"), Operatore.MAGGIORE_UGUALE);
	//EspressioneConfronto c8 = new EspressioneConfronto(new Costante("C"), new Costante("C"), Operatore.MAGGIORE_UGUALE);
	EspressioneConfronto c8 = new EspressioneConfronto(new Stringa("C"), new Stringa("C"), Operatore.UGUALE);
	EspressioneSomma c9 = new EspressioneSomma(new Booleano(false),new Booleano(true),new Booleano(true));
	EspressioneConfronto c10 = new EspressioneConfronto(v1,new Intero(9),Operatore.UGUALE);
	System.out.println(c.getValore());
	System.out.println(c2.getValore());
	System.out.println(c3.getValore());
	System.out.println(c4.getValore());
	System.out.println(c5.getValore());
	//System.out.println(c6.getValore());
	//System.out.println(c7.getValore());
	System.out.println(c8.getValore());
	System.out.println(c2.getTipo());
	System.out.println(c9.getTipo());
	System.out.println(c10.getValore());
	}
	catch(TipiIncopamtibiliException e) {System.out.print(e);}
	}
	

}
