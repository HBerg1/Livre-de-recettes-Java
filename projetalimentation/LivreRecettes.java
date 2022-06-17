//Cyril LIN 28633410

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LivreRecettes {

	private static final LivreRecettes LIVRE_RECETTES = new LivreRecettes();
	public static ArrayList<String> livrerecette = new ArrayList<>();

	
	private static boolean platFroid = false;
	private static boolean platChaud = false;

	private static int nbPlatChaud = 0;
	private static int nbPlatFroid = 0;

	


	private LivreRecettes() {}


	//Renvoie la premiere ligne d'une String qui contient une tabulation \t au debut et fini par un saut de ligne \n
	public static String firstLinetn(String string)
	{
		int first,last;

		for(first = 0;first<string.length();first++)
		{
			if(string.charAt(first) != '\t')
			{
				break;
			}
		}

		for(last = first;first<string.length();last++)
		{
			if(string.charAt(last) =='\n')
				break;
		}

		String res = "";
		for(int k=first;k<last;k++)
		{
			res+=string.charAt(k);
		}
		return res;
	}

	//Permet d'ajouter des recettes dans le livre de recettes
	public static void addRecette(Recette recette)
	{
		if(recette instanceof PlatChaud)
		{
			if(!platChaud)
			{
				livrerecette.add("\t\t\tPlatChaud\n");
				platChaud = true;
			}
			livrerecette.add(livrerecette.indexOf("\t\t\tPlatChaud\n")+ ++nbPlatChaud,recette.toString());
		}
		
		if(recette instanceof PlatFroid)
		{
			if(!platFroid)
			{
				livrerecette.add("\t\t\tPlatFroid\n");
				platFroid = true;
			}
			livrerecette.add(livrerecette.indexOf("\t\t\tPlatFroid\n")+ ++nbPlatFroid,recette.toString());

		}
	}
	
	
	//Renvoie le singleton LIVRE_RECETTES
	public static LivreRecettes getLivreRecettes()
	{
		livrerecette.add("\t\t\tSommaire\n");
		return LIVRE_RECETTES;
	}
	
	//Rafraichi le sommaire pour connaitre les pages des autres recettes
	private void sommaire()
	{
		String string = "\t\t\tSommaire\n\n";

		for(int i = 1; i<livrerecette.size();i++)
		{
			string+= firstLinetn(livrerecette.get(i).toString())+" page "+(i+1)+"\n";
		}
		
		livrerecette.set(0,string);
	}

	//renvoie la page d'indice i-1 de l'ArrayList
	public String getPageindex(int i) throws MyException
	{
		try {
			if (i>livrerecette.size() || i<=0)
			{
				throw new MyException();
			}

		}catch (MyException e)
		{
			System.out.println("Cette page n'existe pas !");
			return  livrerecette.get(0)+"\npage "+1;
		}
		return livrerecette.get(i-1)+"\npage "+i;
	}

	//permet de lire le livre de recettes : tourner les pages, se rendre a une page precise
	public void lire() throws MyException{

		sommaire();
		Scanner scanner = new Scanner(System.in);

		int pageActuelle = 1;
		int pageClient = 1;

		while (pageClient !=0)
		{

			System.out.print("\033[H\033[2J");  
    		System.out.flush();  

			if(pageClient == -1 && pageActuelle >1)
			{
				pageActuelle--;
			}

			if(pageClient == -2 && pageActuelle<livrerecette.size())
			{
				pageActuelle++;
			}
			if( pageClient>0)
				pageActuelle = pageClient;

			System.out.println(getPageindex(pageActuelle));


			if(pageActuelle > 1 && pageActuelle<=livrerecette.size())
			{
				System.out.println("-1 : precedent");
			}
			if(pageActuelle<livrerecette.size() && pageActuelle >=1)
			{
				System.out.println("-2 : suivant");
			}

			System.out.println("0 : quitter");
			
			try {
				pageClient = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Ce n'est pas un nombre");
				break;
			}
		}
		scanner.close();
	}

	//renvoie la chaine de caracteres associee au livre de recette
	public String toString() {
		sommaire();
		String string ="";

		for(String s : livrerecette)
		{

			string+=s+"\n";

		}

		return string;
	}
}


