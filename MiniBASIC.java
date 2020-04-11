package primo;

public class MiniBASIC {
	public void esegui() {}
	public static void main(String[] args) {
		Variabile.valueOf("$3").setValore( "42");
		System.out.println((int)Variabile.$3.getValore()+3);
	}

}
