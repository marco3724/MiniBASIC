package espressioni;

import eccezioni.OperatoreNonTrovatoException;
import eccezioni.TipiIncopamtibiliException;

/**
 * questa classe definisce un espressione con valore booleano derivato da due confronti, 
 * non ha un campo valore perche viene sempre calcolato da un metodo in quanto 
 * se sono presenti variabili,deve cambiare di conseguenza al variare delle variabili
 * @author marco
 *
 */
public class EspressioneConfronto extends EspressioneComposta {

	
	/**
	 * operatore fra due espressioni
	 */
	private Operatore op;
	
	/**
	 * operatori predefiniti
	 * @author marco
	 *
	 */
	public enum Operatore{
		UGUALE("=="),MAGGIORE_UGUALE(">="),MINORE_UGUALE("<="),MAGGIORE(">"),MINORE("<"),DIVERSO("<>");
		String simbolo;
		private Operatore(String simbolo) {
			this.simbolo = simbolo;
		}
		public static Operatore getOperatore(String simbolo) throws OperatoreNonTrovatoException  {
			for(Operatore op : Operatore.values()) 
				if(op.simbolo.equals(simbolo)) return op;
			 throw new OperatoreNonTrovatoException(simbolo);
			
			
		}
	}
	/**
	 * 
	 * @param e1 prima espressione da confrontare
	 * @param e2 seconda espressione da confrontare
	 * @param op operatore usato per il confronto
	 * @throws TipiIncopamtibiliException se non sono dello stesso tipo ,viene lanciato un errore
	 */
	public EspressioneConfronto(Espressione e1,Espressione e2,Operatore op) throws TipiIncopamtibiliException {
		super(Tipo.BOOLEANO,e1,e2);
		this.op = op;
		
	}
	/**
	 * 
	 * @return ritorna un valore booleano di un confronto
	 */
	private boolean Confronto() {
		boolean t;
		return switch(super.getEspressione()[0].getTipo()) {
			case BOOLEANO->
				t = switch(this.op) {
					case UGUALE->super.getEspressione()[0].getValore().equals(super.getEspressione()[1].getValore() );
					case DIVERSO -> !(super.getEspressione()[0].getValore().equals(super.getEspressione()[1].getValore() ));
					default -> throw new IllegalArgumentException("operatore non valido per questo tipo di espressione: " + this.op);
				};
			case INTERO->
				t = switch(this.op) {
					case UGUALE-> (int)super.getEspressione()[0].getValore() == (int)super.getEspressione()[1].getValore();
					case DIVERSO ->!((int)super.getEspressione()[0].getValore() == (int)super.getEspressione()[1].getValore());
					case MAGGIORE -> (int)super.getEspressione()[0].getValore() > (int)super.getEspressione()[1].getValore();
					case MAGGIORE_UGUALE -> (int)super.getEspressione()[0].getValore() >= (int)super.getEspressione()[1].getValore();
					case MINORE -> (int)super.getEspressione()[0].getValore() < (int)super.getEspressione()[1].getValore();
					case MINORE_UGUALE -> (int)super.getEspressione()[0].getValore() <= (int)super.getEspressione()[1].getValore();
				};
			case STRINGA->
				t = switch(this.op) {
				case UGUALE->super.getEspressione()[0].getValore().equals(super.getEspressione()[1].getValore() );
				case DIVERSO -> !(super.getEspressione()[0].getValore().equals(super.getEspressione()[1].getValore() ));
				default -> throw new IllegalArgumentException("operatore non valido per questo tipo di espressione: " + this.op);
				};	
		};	
	}
	/**
	 * @return ritorna il valore(booleano) del confronto
	 */
	@Override
	public Object getValore() {
		return Confronto();
	}
	
	
	

}
