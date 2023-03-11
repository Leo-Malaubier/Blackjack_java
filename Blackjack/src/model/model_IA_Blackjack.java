package model;

import Carte.*;

/** classe deinisant un bot extands de bot
 * @see  Bot#Bot(Paquet paquet,String whoIAm)
 * @author 21903309
 * */

public class model_IA_Blackjack extends Bot {
	private MakeCarte carteCroupierVisible;
	  /**
	    * constructeur d'un bot avec sont paqué et qui il est
	    * @see  Bot#Bot(Paquet paquet,String whoIAm)
	    * @param paquet un paquet de carte
	    * @param whoIAm le nom de qui il est (joueur, bot ou croupier)
	    */
	public model_IA_Blackjack(Paquet paquet,String whoIAm) {
		super(paquet,whoIAm);
	}
	   /**
	    * getter permet définir la carte visible du croupier
	    * @param carte visible du croupier (carte du dessus du paque)
	    */
	public void setCarteCroupierVisible(MakeCarte carte) {
		this.carteCroupierVisible= carte;
	}
	   /**
	    * @return la carte visible du croupier
	    * permet de connaitre la carte visible du croupier
	    */
	public MakeCarte getCarteCroupier() {
		return this.carteCroupierVisible;
	}
	
	  /**
     * @return renvoie une valeur boolean correspondant au choix de jeux
     * cette methode renvoie true s'il faut pioché une carte, false sinon
     */
	
@Override		//pioche ou pas
	public boolean makeChoice() {
		int valueCroupierCart=this.CalculeCarteValue(this.carteCroupierVisible,false);
		if(this.point >= 21) {
			return false;
		}else {
			boolean as=false;
			for(int i=0;1<=this.paquet.getlength()-1;i++) {
				if(this.paquet.getExistsByTypeByIndex(i,"as")==true) {
					as=true;
				}
			}
			if (as==true) {
				this.calculePoint(false);
				if(this.point>21) {
					this.calculePoint(true);
				}
			}else {
				this.calculePoint(false);
			}
			if(this.point>=21) {
				return false;
			}
			if(this.point>=17 && this.point<=21) {
				return false;
			}else if(this.point>=13 && this.point<=16) {
				if(valueCroupierCart>=2 && valueCroupierCart<=6) {
					return false;
				}else {
					return true;
				}
			}else if(this.point==12) {
				if(valueCroupierCart>=4 && valueCroupierCart<=6) {
					return false;
				}else {
					return true;
				}
			}else if(this.point>=2 && this.point<=11) {
				return true;
			}
		}
		return false;
	}

}
