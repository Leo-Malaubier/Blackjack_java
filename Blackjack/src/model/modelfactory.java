package model;
import java.util.*;
import Carte.*;
/** classe factory permettant de construre des bot, un croupier et un joueur
 * @author 21903309
 * */
public class modelfactory extends important_Variables {

	private model_IA_Croupier_BlackJack croupier;
	private modelplayer joueur;
	private ArrayList<model_IA_Blackjack> bot = new ArrayList<>();
	
	   /** 
	    * construction qui permet d'initialisé un joueur, un croupier et plusieur bot
	    * avec le necéssaire dont ils ont besoin pour joué.
	    * C'est a dire leur paquet de carte respectfi et pour le croupier, une deffause vide et une pioche de 8*52 cartes.
	    * @param Nbot prend un int pour connaitre le nombre de bot dans la partie
	    */
	    
	
	public modelfactory(int Nbot) {
		if(Nbot!=0) {
			if (Nbot>2) {
				Nbot=2;
			}
			for(int i=0;i<=Nbot-1;i++) {
				Paquet paquet = factory.makeEmptydeck();
				model_IA_Blackjack bot = new model_IA_Blackjack(paquet,nameBot);
				this.setBot(bot);
			}
		}
		model_IA_Croupier_BlackJack croupier = new model_IA_Croupier_BlackJack(factory.makeEmptydeck(),nameCroupier);
		croupier.setPioche(factory.makeNpaquetWithDeck(nPaquet));
		croupier.setDefausse(factory.makeEmptydeck());
		this.croupier = croupier;
		
		modelplayer joueur = new modelplayer(factory.makeEmptydeck(),namePlayer);
		this.joueur = joueur;
		
	}
	   /**
	    * getter qui permet d'avoir le croupier
	    * @return renvoie un objet croupier
	    */
	public model_IA_Croupier_BlackJack getCroupier(){
		return this.croupier;
	}
	   /**
	    * @param cr définie un croupier
	    * permet de définir un croupier
	    */
	public void setCroupier(model_IA_Croupier_BlackJack cr) {
		this.croupier = cr;
	}
	   /**
	    * getter qui permet d'otenir un objet joueur (modelplayer)
	    * @return renvoie un objet joueur (modelplayer)
	    */
	public modelplayer getJoueur() {
		return this.joueur;
	}
	   /**
	    * @param j modelplayer un objet joueur (modelplayer)
	    * permet de définir un objet joueur (modelplayer)
	    */
	public void setJoueur(modelplayer j) {
		this.joueur=j;
	}
	   /**
	    *getter qui permet d'avoir une liste de bot
	    * @return une arrayeListe de bot model_IA_Blackjack
	    */
	public ArrayList<model_IA_Blackjack> getbot() {
		return this.bot;
	}
	   /**
	    * @param bot défini un bot model_IA_Blackjack
	    * permet de définri un bot
	    */
	public void setBot(model_IA_Blackjack bot) {
		this.bot.add(bot);
	}
	
}

