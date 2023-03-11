package blackjack;

import model.*;
import java.util.*;
import Carte.*;

import controller.controller;

/** classe main proposant une parite de blackjack
 * @author 21903309
 * */
public class main extends important_Variables{

	  /**
	    * méthode main initialisant la partie
	    * @param args non utiliser
	    */
	public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);  
	System.out.println("combien d'aversaires voulez vous? (min: 0, max: 2)");
	int n = reader.nextInt(); 
	reader.close();
	
	main MainObjet = new main();
	MainObjet.makegame(n);
	
	}
	  /**
	    * méthode makegame faisant tourné une partie de blackjack 
	    * @param Nbot, prend le nombre de bot demandé
	    */
	public void makegame(int Nbot) {
		controller controller = new controller();
		modelfactory ModelFactory = new modelfactory(Nbot);
		
		boolean end = false;
		int tour=0;
		
		Paquet pioche = ModelFactory.getCroupier().getPioche();
		//Paquet defausse = factory.getCroupier().getDefausse();
		modelplayer joueur= ModelFactory.getJoueur();
		model_IA_Croupier_BlackJack croupier = ModelFactory.getCroupier();
		
		MakeCarte CarteVisibleCroupier;
		
		ArrayList<model_IA_Blackjack> bot = ModelFactory.getbot();
		
			while(end!=true) {
				if(verifScore(joueur,bot,Nbot)==true){ //si tout le monde est a false; stop
					if(tour == 0) { //distribue les carte au premier tour
						for(int i=0;i<=1;i++) {
							MakeCarte carte=pioche.getGetcarte(0);
							pioche.removeFirstCarte();
							joueur.setPaquet(carte);
						}
						if(Nbot!=0) {
							for(int i=0;i<=1;i++) {
								for(int j=0;j<=Nbot-1;j++) {
									MakeCarte carte=pioche.getGetcarte(0);
									pioche.removeFirstCarte();
									model_IA_Blackjack actualBot = bot.get(i);
									actualBot.setPaquet(carte);
									bot.set(i, actualBot);
								}
							}
						}
						for(int i=0;i<=1;i++) {
							MakeCarte carte=pioche.getGetcarte(0);
							pioche.removeFirstCarte();
							croupier.setPaquet(carte);
						}
						
					tour=1;
					
					}else {
						CarteVisibleCroupier = croupier.getPaquet().getGetcarte(0);
						if(joueur.playing!=false) {
							if(controller.turnOfPlayer(joueur,CarteVisibleCroupier)==true) {
								MakeCarte carte=pioche.getGetcarte(0);
								pioche.removeFirstCarte();
								joueur.setPaquet(carte);
							}else {
								joueur.setPlaying(false);
							}
						}
						if(Nbot!=0) {
							for(int i=0;i<=Nbot-1;i++){
								model_IA_Blackjack actualBot = bot.get(i);
								actualBot.setCarteCroupierVisible(CarteVisibleCroupier);
									if(actualBot.playing==true) {
										if(actualBot.makeChoice()==true) {
											MakeCarte carte=pioche.getGetcarte(0);
											pioche.removeFirstCarte();
											actualBot.setPaquet(carte);
											bot.set(i, actualBot);
											controller.turnOfBot(actualBot); //affichage les carte du bot
										}else {
											actualBot.setPlaying(false);
											bot.set(i, actualBot);
										}
									}
							}
						}
					}
			}else{
				//MaxPlayer;
				int MaxValue=0;
				joueur.calculePointAll();
				if(joueur.getPoint()>=MaxValue) {
					MaxValue=joueur.getPoint();
				}
				for (int i=0;i<=Nbot-1;i++) {
					model_IA_Blackjack actualBot = bot.get(i);
					actualBot.calculePointAll();
					if(actualBot.getPoint()>=MaxValue) {
						MaxValue=actualBot.getPoint();
					}
					bot.set(i, actualBot);
				}
				croupier.setValueMaxPlayer(MaxValue);
				while(croupier.playing!=false) {
					if(croupier.makeChoice()==true) {
						MakeCarte carte=pioche.getGetcarte(0);
						pioche.removeFirstCarte();
						croupier.setPaquet(carte);
					}else {
						croupier.setPlaying(false);
					}
				}
					
				controller.turnOfCroupier(croupier);
				controller.showResult(joueur,croupier,bot,Nbot);
				controller.AskForQuit();
				end=true;
			}
		}
	}
	
	  /**
	    * méthode verifScore qui permet de vérifier que tout les joueur (bot et player) on arraité de demandé des cartes.
	    * @param joueur prend un objet modelplayer pour connaitre c'est cartes
	    * @param bot prend une liste model_IA_Blackjack pour connaitre leur cartes 
	    * @param Nbot pour connairte le nombre de bot de la partie (int)
	    * @return renvoie un boolean pour savoir s'il y a encore des joueur qui joue ou pas. true si oui false sinon.
	    */
	public boolean verifScore(modelplayer joueur,ArrayList<model_IA_Blackjack> bot,int Nbot) {
		if(Nbot==1) {
			if(joueur.playing==false && bot.get(0).playing==false) {
				return false;
			}else {
				return true;
			}
		}else if (Nbot==2) { 
			if(joueur.playing==false && bot.get(0).playing==false && bot.get(1).playing==false) {
			return false;
			}else {
				return true;
			}
		}else {
			if(joueur.playing==false) {
				return false;
			}else {
				return true;
			}
		}
		
	}
	
}
