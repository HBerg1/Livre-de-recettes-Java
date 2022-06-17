
public class Test {
	public static void main(String[] args) throws MyException {

		LivreRecettes livreRecettes = LivreRecettes.getLivreRecettes();
		PlatChaud Quichelorraine = new PlatChaud("Quichelorraine",10,45,8);

		Quichelorraine.addIngredient(new Ingredient("pate brisee",200,"g"));
		Quichelorraine.addIngredient(new Ingredient("lait",20,"cl"));
		Quichelorraine.addIngredient(new Ingredient("muscade",5,"g"));
		Quichelorraine.addIngredient(new Ingredient("sel",5,"g"));
		Quichelorraine.addIngredient(new Ingredient("poivre",5,"g"));
		Quichelorraine.addIngredient(new Ingredient("lardons",200,"g"));
		Quichelorraine.addIngredient(new Ingredient("beurre",30,"g"));
		Quichelorraine.addIngredient(new Ingredient("oeufs",3,""));
		Quichelorraine.addIngredient(new Ingredient("creme fraiche",20,"cl"));

		Quichelorraine.addInstruction("Prechauffer le four a 180 C (thermostat 6). Etaler la pate dans un moule,");
		Quichelorraine.addInstruction("la piquer a la fourchette. Parsemer de copeaux de beurre.");
		Quichelorraine.addInstruction("Faire rissoler les lardons a la poele puis les eponger avec une feuille d'essuie-tout.");
		Quichelorraine.addInstruction("Battre les oeufs, la creme fraiche et le lait.");
		Quichelorraine.addInstruction("Ajouter les lardons.");
		Quichelorraine.addInstruction("Assaisonner de sel, de poivre et de muscade.");
		Quichelorraine.addInstruction("Verser sur la pate.");
		Quichelorraine.addInstruction("Cuire 45 a 50 min.");
		Quichelorraine.addInstruction("C'est pret");
		Quichelorraine.addInstruction("Deguster");




		PlatFroid glace = new PlatFroid("Glace facile et rapide", 10, 0, 4);
		glace.addIngredient(new Ingredient("sucre", 3, " cuillere a soupe"));
		glace.addIngredient(new Ingredient("creme fraiche",20,"cl"));
		glace.addIngredient(new Ingredient("sirop de fraise",8," cuillere a soupe"));
		glace.addInstruction("Dans un plat muni d'un bec verseur, mettre la creme fraiche, le sucre et le sirop. Melanger le tout au fouet a main jusqu'a ce que le sucre soit fondu et le melange soit homogene.");
		glace.addInstruction("Verser la preparation dans un support pour 4 glaces et mettre au congelateur quelques heures.");

		PlatChaud faussequiche = new PlatChaud(Quichelorraine);
		faussequiche.setNomRecette("fausse quiche");

		livreRecettes.addRecette(Quichelorraine);
		livreRecettes.addRecette(glace);
		livreRecettes.addRecette(faussequiche);

		livreRecettes.lire();

		LivreRecettes livreRecettes2 = LivreRecettes.getLivreRecettes();
		livreRecettes2.addRecette(Quichelorraine);
		
		//System.out.println(livreRecettes2);
	}
}
