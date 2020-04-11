package primo;

public class EspressioneComposta  implements Espressione{
	Espressione e1;
	Espressione e2;
	Operatore op;
	enum Operatore{
		PIU,MENO,PER,DIVISO;
	}
	public EspressioneComposta(Espressione a,Espressione b,Operatore op ) {
		e1 = a;
		e2 = b;
		this.op = op;
	}
	@Override
	public Object getValore() 
	{
		e1.
	}

}
