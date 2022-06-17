
public class PlatChaud extends Plat implements Chaud{

	public PlatChaud(String nomRecette, int tempsPreparation, int tempsCuisson, int nbPersonnes) {
		super(nomRecette, tempsPreparation, tempsCuisson, nbPersonnes);
	}

	public PlatChaud(PlatChaud platChaud)
	{
		super(platChaud);
	}

}
