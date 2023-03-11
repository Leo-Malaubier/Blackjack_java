package model;

import Carte.*;
/** classe abstatie définistant ce qu'est un joueur.
 * Les bot et les croupier sont aussi définie comme des joueur.
 * @author 21903309
 * */
public abstract class joueur {
	/** itinitalisation de la varaibel playing permettant de saoir si le joueur joue ou pas boolean true pour joue et false pour ne joue pas*/
	public boolean playing=true; 
	/** initialisation d'un paquet*/
	public Paquet paquet; 
	 /**initialisation d'un string conteant le nom de qui on est (bot, joueur ou croupier)*/
	public String WhoIAm;
	/** initialisation de la variable point pour savoir combien de point a le joeur au total*/
	public int point=0; 
	
	  /**
	    * construction d'un joueur
	    * @param paquet prend un paqué en entré pour définir le paqué que le joueur aura
	    * @param WhoIAm permet de savoir si la joueur est un joueur, bot ou croupier
	    */
	public joueur(Paquet paquet,String WhoIAm) {
		this.paquet=paquet;
		this.WhoIAm=WhoIAm;
	}
	  /**
	    * calculePointAll, permet de calculé le nombre de point obtenue grace a nos cartes.
	    * peux importe le joueur ni s'il possaide des as ou pas.
	    */
	public void calculePointAll() {
		this.point=0;
		boolean AsOne=false;
		for(int i=0;1<=this.paquet.getlength()-1;i++) {
			this.point+=this.calculeValueOf(this.paquet.getGetcarte(i),AsOne);
		}
		if(this.point>21) {
			for(int i=0;1<=this.paquet.getlength()-1;i++) {
				if(this.paquet.getExistsByTypeByIndex(i,"as")==true) {
					AsOne=true;
				}
			}
			this.point=0;
			for(int i=0;1<=this.paquet.getlength()-1;i++) {
				this.point+=this.calculeValueOf(this.paquet.getGetcarte(i),AsOne);
			}
		}
			
	}
	  /**
	    * calculePoin, permet de calculé le nombre de point obtenue grace a nos cartes.
	    * (set principalement utilisé par des mathodes.
	    * @param AsOne défini si oui ou non on utilise un as dans note contage. car l'as vaut 1 ou 11
	    */
	public void calculePoint(boolean AsOne){
		for(int i=0;1<=this.paquet.getlength()-1;i++) {
			this.point+=this.calculeValueOf(this.paquet.getGetcarte(i),AsOne);
		}
	}
	  /**
	    * CalculeCarteValue permet d'appelé la classe privé calculeValueOf
	    * elle permet de calculé la valeur d'une seul carte passé en paramètre
	    * on peux aussi définir si l'on utilise un as ou pas, si l'on veux la l'as face 1 ou 11
	    * @param AsOne défini si oui ou non on utilise un as dans note contage. car l'as vaut 1 ou 11
	    * @param carte prend une carte en antré c qui permet de calulé sa valeur
	    * @return la valeur de la carte
	    */
	public int CalculeCarteValue(MakeCarte carte,boolean AsOne) {
		return calculeValueOf(carte,AsOne);
	}
	  /**
	    * calculeValueof calcule la valeur de la carte prise en entré
	    * @param AsOne défini si oui ou non on utilise un as dans note contage. car l'as vaut 1 ou 11
	    * @param carte prend une carte en antré c qui permet de calulé sa valeur
	    * @return la valeur de la carte
	    */
	private int calculeValueOf(MakeCarte carte,boolean AsOne) {
		String type = carte.getType();
		if (AsOne == true) {
			if (carte.getType()=="as") {
				return 1;
			}
		}
		switch(type) {
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "10":
			return 10;
		case "valet":
			return 10;
		case "dame":
			return 10;
		case "roi":
			return 10;
		case "as":
			return 11;
		}
		return 0;
	}
	  /**
	    * removall permet de vidé le paqué de carte d'un joueur(bot, croupier ou joueur)
	    * 
	    */
	public void removall() {
		for(int i=1;i<=this.paquet.getlength();i++) {
			this.paquet.removeIndex(i);
		}
	}
	  /**
	    * axcesseur du paqué de carte du joueur (bot, croupier ou joueur)
	    * @return le paqué de la classe
	    */
	public Paquet getPaquet() {
		return this.paquet;
	}
	  /**
	    * setPaquet permet d'ajouté une carte au paqué d'un joueur  (bot, croupier ou joueur)
	    * @param carte prend un objet carte en entre
	    */
	public void setPaquet(MakeCarte carte) {
		this.paquet.addcartOnBot(carte);
	}
	  /**
	    * axcesseur au nombre de point du joueur (bot, croupier ou joueur)
	    * @return une valeur int correspondant au point de la class joueur
	    */
	public int getPoint() {
		return this.point;
	}
	  /**
	    * permet de définir a l'enviedu joueur (bot, croupier ou joueur) de vouloir joué ou de s'arraité.
	    *@param value prend un boolean pour savoir si le joueur joue
	    */
	public void setPlaying(boolean value) {
		this.playing=value;
	}
	  /**
	    * axcesseur a l'enviedu joueur (bot, croupier ou joueur) de vouloir joué ou de s'arraité.
	    * @return une valeur boolean true pour continuer a joué, false pour s'arraité
	    */
	public boolean getPlaying() {
		return this.playing;
	}
}
