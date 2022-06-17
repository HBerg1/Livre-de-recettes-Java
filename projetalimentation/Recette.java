
import java.util.ArrayList;

public abstract class Recette {
	private String nomRecette;
	private ArrayList<Ingredient> tabIngredients;
	private int tempsPreparation;
	private int tempsCuisson;
	private ArrayList<String> instructions;
	private int nbPersonnes;

	//Permet de creer une recette avec les bons arguments
	public Recette(String nomRecette,int tempsPreparation, int tempsCuisson, int nbPersonnes )
	{
		this.nomRecette = nomRecette;
		this.tempsPreparation = tempsPreparation;
		this.tempsCuisson = tempsCuisson;
		this.nbPersonnes = nbPersonnes;
		tabIngredients = new ArrayList<>();
		instructions = new ArrayList<>();
	}

	//Constructeur par copie
	public Recette(Recette recette)
	{
		this.nomRecette = recette.nomRecette;
		this.tempsPreparation = recette.tempsPreparation;
		this.tempsCuisson = recette.tempsCuisson;
		this.nbPersonnes = recette.nbPersonnes;
		tabIngredients = new ArrayList<>(recette.tabIngredients);
		instructions = new ArrayList<>(recette.instructions);
	}
	
	public void addInstruction(String instruction)
	{
		instructions.add(instruction);
	}
	
	public void removeInstructionIndex(int index)
	{
		try {
			instructions.remove(index);
		}catch (Exception e)
		{
			System.out.println("Cette indice n'existe pas !");
			return ;
		}

	}
	
	public void addIngredient(Ingredient i)
	{
		tabIngredients.add(i);
	}

	public void setNomRecette(String s)
	{
		this.nomRecette = s;
	}


	public String toString() {
		String string="\t\t\t"+nomRecette+"\n\n";
		string+= "Nombre de personne(s) : " +nbPersonnes+"\n";
		string+= "Temps de preparation : " +tempsPreparation +" minute(s), temps de cuisson : "+ tempsCuisson +" minute(s)\n\n";
		boolean isFirst = true;
		
		for(Ingredient ingredient : tabIngredients)
		{
			if(isFirst)
			{
				string+="Ingredients : \n";
				isFirst = false;
			}
			string+= ingredient.toString()+"\n";
		}
		isFirst = true;
		
		for(String instruction : instructions)
		{
			if(isFirst)
			{
				string+="\nEtape : \n";
				isFirst = false;
			}
			string+="Etape "+(instructions.indexOf(instruction)+1)+"\n" +  instruction+"\n\n";
		}
		
		
		return string;
	}
}
