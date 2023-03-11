package model;
import Carte.*;
/** classe deinisant un bot_croupier extands de bot
 * @see  Bot#Bot(Paquet paquet,String whoIAm)
 * @author 21903309
 * */
public class model_IA_Croupier_BlackJack extends Bot{
	private int ValueJoueurMax;
	private Paquet pioche;
	private Paquet defausse;
	  /**
	    * constructeur d'un bot avec sont paqué et qui il est
	    * @see  Bot#Bot(Paquet paquet,String whoIAm)
	    * @param paquet prend un paquet de carte en entre
	    * @param whoIAm prend un String en antre desigant le joueur
	    */
	public model_IA_Croupier_BlackJack(Paquet paquet,String whoIAm) {
		super(paquet,whoIAm);
	}

	//pioche ou pas
	  /**
     * @return renvoie une valeur boolean correspondant au choix de jeux
     * cette methode renvoie true s'il faut pioché une carte, false sinon
     */
	public boolean makeChoice() {
		if(this.point > this.ValueJoueurMax) {
			return false;
		}else if(this.point< this.ValueJoueurMax) {
			return true;
		}else if(this.point == this.ValueJoueurMax) {
			return false;
		}
		return false;
	}
	   /**
	    * setter permet définir le nombre de point maximal que les joueur on
	    * @param valueMax un int de la valeur max
	    * 
	    */
	public void setValueMaxPlayer(int valueMax) {
		this.ValueJoueurMax=valueMax;
	}
	   /**
	    * @return un int de la valeur max des points des joueurs
	    * permet de connaitre les points max des joueurs
	    */
	public int getValueMaxPlayer() {
		return this.ValueJoueurMax;
	}
	   /**
	    * setter permet définir la pioche de la partie
	    * @param pioche prend un paqué de N carte
	    */
	public void setPioche(Paquet pioche) {
		this.pioche=pioche;
	}
	   /**
	    * @return renvoie le paquet de la pioche
	    * permet d'avoir le paquet de la pioche
	    */
	public Paquet getPioche() {
		return this.pioche;
	}
	   /**
	    * setter permet définir un paqué de defausse (généralement un paqué vide)
	    * @param defausse prend un paquet de carte
	    */
	public void setDefausse(Paquet defausse) {
		this.defausse=defausse;
	}
	   /**
	    * @return renvoie la paquet de la defausse
	    * permet d'avoir le paquet de defausse
	    */
	public Paquet getDefausse() {
		return this.defausse;
	}
}
