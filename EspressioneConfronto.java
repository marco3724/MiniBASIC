package primo;

public class EspressioneConfronto extends EspressioneComposta {
	private boolean valore;
	private Operatore op;
	public EspressioneConfronto(Espressione e1,Espressione e2,Operatore op) throws TipiIncopatibiliException {
		super(e1,e2);
		this.op = op;
		//System.out.println((int)super.getEspressione()[0].getValore() );
		valore = Confronto();
	}
	enum Operatore{
		UGUALE,MAGGIORE_UGUALE,MINORE_UGUALE,MAGGIORE,MINORE,DIVERSO;
	}
	private boolean Confronto() {
		boolean t;
		return switch(tipo) {
			case BOOLEANO->
				t = switch(this.op) {
					case UGUALE->super.getEspressione()[0].getValore().equals(super.getEspressione()[1].getValore() );
					case DIVERSO -> !(super.getEspressione()[0].getValore().equals(super.getEspressione()[1].getValore() ));
					default -> throw new IllegalArgumentException("Unexpected value: " + this.op);
	

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
				default -> throw new IllegalArgumentException("Unexpected value: " + this.op);
				};	
		};	
	}

	@Override
	Object getValore() {
		
		return valore;
	}
	
	
	

}
