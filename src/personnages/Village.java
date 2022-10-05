package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;

	private Gaulois[] villageois;
	private Chef chef;

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Village(String nom, int nbVillageoisMaximum) {
		super();
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(int num) {

		return villageois[num];

	}

	public static void main(String[] args) {

		Village village = new Village("Village des Irréductibles", 30);

//		Gaulois gaulois = village.trouverHabitant(30);
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
//		at personnages.Village.trouverHabitant(Village.java:33)
//		at personnages.Village.main(Village.java:41)
//		On dépasse les bornes du tableau (index max = 29)

		Chef chef = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		village.setChef(chef);
//		Gaulois gaulois = village.trouverHabitant(1);
//		null;
//		null = valeur par défaut dans un tableau non complété;
		System.out.println(gaulois);

	}

	public void afficherVillageois() {
		
	}
	
}
