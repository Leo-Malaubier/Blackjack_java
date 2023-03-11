package model;

import Carte.Paquet;
/** classe deinisant un joueur (player)
 * @see  joueur#joueur(Paquet paquet,String whoIAm)
 * @author 21903309
 * */
public class modelplayer extends joueur{
	/**
	 * constructeur modelplayer
	 * @param paquet prend un paquet
	 * @param WhoIAm prend un string de sont nom (player)
	 */
	public modelplayer(Paquet paquet,String WhoIAm) {
		super(paquet,WhoIAm);
	}
}
