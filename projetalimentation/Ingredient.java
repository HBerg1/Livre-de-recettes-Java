

public class Ingredient {
	private String nomIngredient;
	private  double quantite;
	private String mesure;
	
	public Ingredient(String nomIngredient, double quantite, String mesure) {
		this.nomIngredient = nomIngredient;
		this.quantite = quantite;
		this.mesure = mesure;
	}
	
	public String toString()
	{
		return quantite+ " " +mesure +" " +nomIngredient;
	}
	
}
