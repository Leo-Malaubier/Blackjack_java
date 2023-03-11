package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Carte.*;
import model.*;
//import view.mainView;

/** classe deinisant l'affichage
 * @author 21903309
 * */
public class controller extends important_Variables{

	
	   /**
	    * turnOfPlayer permet de mettre a jour l'affichage du joueur.
	    * Et luis permet de choisir l'action qu'il veux faire.
	    * @param player l'objet joueur (modelplayer) pour connaitre c'est carte.
	    * @param cartecroupier pour connaire la carte visible du croupier.
	    * @return renvoie le choix fait pas le joueur (un boolean true/false)
	    */
	public boolean turnOfPlayer(modelplayer player,MakeCarte cartecroupier) {
		System.out.println("voici vos cartes:");
		Paquet paquetPlayer=player.getPaquet();
		for(int i=0;i<=paquetPlayer.getlength()-1;i++) {
			System.out.println(paquetPlayer.getGetcarte(i).toString());
		}
		System.out.println("voici la carte visible du croupier:");
		System.out.println(cartecroupier.toString());
		return this.makeChoicePalyer();
	}
	
	   /**
	    * makeChoicePlayer est une méthode appelé par turnOfPlayer permettant d'attendre et de définir je choix du joueur.
	    * Et luis permet de choisir l'action qu'il veux faire.
		* @return un boolean true pour pioché une carte, false, pour s'arraité de joué.
	    */
	private boolean makeChoicePalyer() {
		Scanner reader = new Scanner(System.in);  
		System.out.println("voulez vous pioché une carte ou vous arraité la?");
		System.out.println("répondez 1 si vous voulez pioché, 0 sinon");
		int n = reader.nextInt(); 
		reader.close();
		if(n==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	   /**
	    *permet de mettre a jour l'affichage d'un bot
		* @param bot prend un objet bot model_IA_Blackjack pour connaitre c'est carte et les affiché
		* 
	    */
	
	public void turnOfBot(model_IA_Blackjack bot){
		System.out.println("Carte d'un bot:");
		Paquet paquetbot=bot.getPaquet();
		for(int i=0;i<=paquetbot.getlength()-1;i++) {
			System.out.println(paquetbot.getGetcarte(i).toString());
		}
	}
	   /**
	    *permet de mettre a jour l'affichage le croupier
		* @param croupier prend un objet bot_croupier model_IA_Croupier_BlackJack pour connaitre c'est carte et les affiché
	    */
	public void turnOfCroupier(model_IA_Croupier_BlackJack croupier) {
		System.out.println("Carte du croupier:");
		Paquet paquetcroupier=croupier.getPaquet();
		for(int i=0;i<=paquetcroupier.getlength()-1;i++) {
			System.out.println(paquetcroupier.getGetcarte(i).toString());
		}
	}
	   /**
	    *prévien que la partie est fini et que l'on vas quitté le programe
	    */
	public void AskForQuit() {
		Scanner reader = new Scanner(System.in);  
		System.out.println("voulez allez quitté le programe appuyé sur entré");
		reader.nextInt(); 
		reader.close();
	}
	   /**
	    *affiche les résultat des gagnant
	    *@param player prend un objet player (modelplayer) pour connaitre c'est cartes
	    **@param croupier prend un objet croupier (model_IA_Croupier_BlackJack) pour connaitre c'est cartes
	    **@param bot prend une liste d' objet bot (model_IA_Blackjack) pour connaitre leurs cartes
	    **@param Nbot int pour connaitr le nombre de bot de la partie
	    */
	public void showResult(modelplayer player,model_IA_Croupier_BlackJack croupier,ArrayList<model_IA_Blackjack> bot,int Nbot) {
		if(player.getPoint()>croupier.getPoint()) {
			System.out.println("Vous avez gagné!");
		}else if(player.getPoint()==21){
			System.out.println("Vous avez gagné!");
		}else if (player.getPoint()<croupier.getPoint()) {
			System.out.println("Domage, vous avez perdu");
		}else if (player.getPoint()==croupier.getPoint()) {
			System.out.println("Egalité avec le croupier!");
		}
		if(Nbot!=0) {
			for(int i=0;i<=Nbot-1;i++) {
				model_IA_Blackjack actualBot = bot.get(i);
				if(actualBot.getPoint()>croupier.getPoint()) {
					System.out.println("Un bot à gagné!");
				}else if(actualBot.getPoint()==21){
					System.out.println("Un bot à gagné!");
				}else if (actualBot.getPoint()<croupier.getPoint()) {
					System.out.println("un bot à perdu");
				}else if (actualBot.getPoint()==croupier.getPoint()) {
					System.out.println("Un bot à fait égalité avec le croupier!");
				}
			}
		}

	}
}
