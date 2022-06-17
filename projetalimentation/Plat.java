
public abstract class Plat extends Recette{

	public Plat(String nomRecette, int tempsPreparation, int tempsCuisson, int nbPersonnes) {
		super(nomRecette, tempsPreparation, tempsCuisson, nbPersonnes);
		
	}
	public Plat(Plat plat)
	{
		super(plat);
	}
}
