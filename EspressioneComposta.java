package primo;

import primo.Espressione.Tipo;

abstract public class EspressioneComposta extends Espressione{
	protected Espressione[] espressione;

	public EspressioneComposta(Espressione... e1) throws TipiIncopatibiliException{
		super(e1[0].tipo);
		espressione = e1;
		if(!sonoDelloStessoTipo()) throw new TipiIncopatibiliException();
	}
	private boolean sonoDelloStessoTipo() {
		Tipo tipo = espressione[0].tipo;
		for(int i = 1;i<espressione.length;i++) {
			if(tipo!=espressione[i].getTipo()) return false;
		}
		return true;
	}
	public Espressione[] getEspressione() {
		return this.espressione;
	}
}
