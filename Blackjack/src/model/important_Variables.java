package model;

import Carte.MakeCarte;
import Carte.Paquet;

/** class Contenant des variables static
 * Cette méthode contien Les nom utilisé pour les bot, croupier et joueur
 * Elle permet de définir également le nombre de paquet utilisé
 * @author 21903309
 * */
public abstract class important_Variables {

	static int nPaquet = 8;
	static String nameBot="bot";
	static String nameCroupier="croupier";
	static String namePlayer="joueur";
	
	
	   /**
	    * @return renvoie le nome utilisé pour les bot
	    * axcesseur simple
	    */
	public String getNameBot() {
		return nameBot;
	}
	   /**
	    * @return renvoie le nome utilisé pour le croupier
	    * axcesseur simple
	    */
	public String getNameCroupier() {
		return nameCroupier;
	}
	   /**
	    * @return renvoie le nome utilisé pour les joueur
	    * axcesseur simple
	    */
	public String getNamePlayer() {
		return namePlayer;
	}
	

	
}
