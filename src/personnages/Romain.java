package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert this.forceSup0();
	}
	
	private boolean forceSup0() {
		return (this.force > 0);
	}
	
	private boolean forceDiminue(int ancienne_force) {
		return ( ancienne_force > this.force);
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + '"' + texte + '"');
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " :";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert this.forceSup0();
//		int ancienne_force = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe !");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert this.forceDiminue(ancienne_force);
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "Mais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				}

				else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
				//TODO
				int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {if (equipements[i] == null) {
			continue;
		} else {
			equipementEjecte[nbEquipementEjecte] =
					equipements[i];
			nbEquipementEjecte++;
			equipements[i] = null;
		}
		}
		return equipementEjecte;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
			break;
		}
		case 1:{
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + getNom() + " Possède déjà un " + equipement);
			}
			else if (equipements[0] != equipement) {
				equipements[1] = equipement;
				System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement);
				nbEquipement++;
			}
			break;
		}
		case 0:{
			equipements[0] = equipement;
			System.out.println("Pas d'équipements");
			System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement);
			nbEquipement++;
			break;
		}
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
//		minus.recevoirCoup(2);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.nbEquipement = 1;
		System.out.println(minus.nbEquipement);
		minus.equipements[0] = Equipement.BOUCLIER;
		minus.sEquiper(Equipement.CASQUE);
		System.out.println(minus.nbEquipement);
		for (int i = 0 ; i < 2 ; i++) {
			System.out.println(minus.equipements[i]);
		}
	}
	
}