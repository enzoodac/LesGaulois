package Histoire;
import personnages.*;
public class Scénario {

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		Gaulois asterix = new Gaulois("Astérix", 6);
		Gaulois obelix = new Gaulois("Obélix",25);
		Romain minus = new Romain("Minus", 13);
		panoramix.parler("Bonjour, je suis le druide Panoramix et ma potion peut aller d'une force 5 à 10.");
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste");
		panoramix.booster(asterix);
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		

	}

}
