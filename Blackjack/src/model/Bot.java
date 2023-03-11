package model;
import Carte.*;

/** class abstraite definisant un bot
 * @author 21903309
 * */
public abstract class Bot extends joueur {
	   /**
	    * construction héritéde joueur
	    * @see joueur#joueur(Paquet c, String t)
	    * @param paquet prend un objet paqué 
	    * @param WhoIAm prend un String en entré 
	    */
	public Bot(Paquet paquet,String WhoIAm) {
		super(paquet,WhoIAm);
	}
	
	   /**
	    * méthode abstait makeChoice pour les bot
	    * ceci permet au bot (bot ou croupier) de choisir l'action qu'il veulent faire
	    * @see joueur#joueur(Paquet c, String t)
	    * @return un boullean pour savoir si le bot joue ou pas (true s'il veux joué false sinon)
	    */
	public abstract boolean makeChoice();
	

}
