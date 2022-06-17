
public class PlatFroid extends Plat implements Froid{

	public PlatFroid(String nomRecette, int tempsPreparation, int tempsCuisson, int nbPersonnes) {
		super(nomRecette, tempsPreparation, tempsCuisson, nbPersonnes);
	}

	public PlatFroid(PlatFroid platFroid)
	{
		super(platFroid);
	}
}
