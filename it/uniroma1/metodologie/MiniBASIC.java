package it.uniroma1.metodologie;


import eccezioni.OperatoreNonTrovatoException;
import eccezioni.TipiIncopamtibiliException;
import espressioni.*;
import espressioni.EspressioneConfronto.Operatore;
import espressioni.Variabile.Nome;
import istruzioni.Assegna;
import istruzioni.Istruzione;
import istruzioni.Print;
import istruzioni.Selezione;
//dovrebbe esserci un eccezione nell'else

public class MiniBASIC {
	public static void main(String[] args) throws NumberFormatException, OperatoreNonTrovatoException {
		int s = 2;
	Variabile v1 = new Variabile(Nome.$0,"2");
	Variabile v2 = new Variabile(Nome.$1,"2");
	Variabile v3 = new Variabile(Nome.$1,s);
	Costante c1 = new Intero(2);
	try {
	//EspressioneSomma c = new EspressioneSomma(v1,c1,new Intero(6),v2);
	/**System.out.println(c.getValore()+"  "+c.getTipo());
	EspressioneConfronto c2 = new EspressioneConfronto(v1, v2, Operatore.UGUALE);
	EspressioneConfronto c3 = new EspressioneConfronto(v1, v2, Operatore.MAGGIORE);
	EspressioneConfronto c4 = new EspressioneConfronto(v2, v1, Operatore.MAGGIORE);
	EspressioneConfronto c5 = new EspressioneConfronto(v2, v1, Operatore.MAGGIORE_UGUALE);
	//EspressioneConfronto c6 = new EspressioneConfronto(new Costante("CIAO"), new Costante(2), Operatore.MAGGIORE_UGUALE);
	//EspressioneConfronto c7 = new EspressioneConfronto(new Costante("CIAO"), new Costante("ciao"), Operatore.MAGGIORE_UGUALE);
	//EspressioneConfronto c8 = new EspressioneConfronto(new Costante("C"), new Costante("C"), Operatore.MAGGIORE_UGUALE);
	EspressioneConfronto c8 = new EspressioneConfronto(new Stringa("C"), new Stringa("C"), Operatore.UGUALE);
	EspressioneSomma c9 = new EspressioneSomma(new Booleano(false),new Booleano(true),new Booleano(true),c2);
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
	System.out.println((Espressione.returnTipo("2")==Espressione.Tipo.INTERO) +"aaaaaaaaaaaa"+ "");
	new Assegna(v2,"ca").esegui();
	new Assegna(v2,"3").esegui();
	//new Print(v2).esegui();
	//Programma p = Programma.fromFile("Desktop");**/
	Programma p1 = Programma.fromFile("prova.txt");
	//p1.istruzioni.get(0).esegui();//FUNGE
	//Programma p = new Programma(new Assegna(v2,"ca"),new Print(v2),new Print(v2),new Print(v2));
	// Print[] a = {new Print("no"),new Print("nono")};
	//Programma p=  Programma.of(new Selezione(new EspressioneConfronto(v2,new Intero(3),Operatore.UGUALE) ,a,new Print("non ciao"),new Print("non ciao")));
	for(Istruzione i: p1) {
		//System.out.println(i);
		//System.out.println(Programma.variabili[1]+" FANCULOOOOOOOOOO");
		i.esegui();
		//System.out.println(Programma.variabili[1]+" FANCULOOOOOOOOOO "+Programma.variabili[1].getValore());
	}
	//new Assegna(v1,c).esegui();
	//System.out.println(v1+"  "+v1.getValore());
	//System.out.println(Programma.variabili[7]);
	//Programma.of("C:\\Users\\uni\\Desktop\\workspace_java\\HomeWork\\src\\ciao.txt");
	//for(int i = 0;i<p.istruzioni.size();i++) {
		//p.istruzioni.get(i).esegui();
	//}
	
	//Variabile[] var = new Variabile[Variabile.getMaxVariabili()];
	//var[1] = new Variabile(Nome.$0,4);
	//System.out.println(var[1].getValore());
	}
	catch(TipiIncopamtibiliException e) {System.out.print(e);}
	//System.out.print("cioaicaoi");
	}
	

}
