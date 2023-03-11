package view;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Carte.*;
import model.*;
/** class permettant l'affichage
 * */
public class Window extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * pullButton zone du bouton tirage 
	 */
	private JPanel pullButton;
	/**
	 * stopButton zone du bouton stop
	 */
	private JPanel stopButton;

	/**
	 * croupier plateau du croupier
	 */
	private JPanel croupier;
	/**
	 * draw zone de la pioche
	 */
	private JPanel draw;
	/**
	 * player plateau du joueur
	 */
	private JPanel player;
	/**
	 * bot1 plateau du bot1
	 */
	private JPanel bot1;
	/**
	 * bot2 plateau du bot2
	 */
	private JPanel bot2;
	/**
	 * croupierPanel zone du croupier avec le plateau du croupier, la zone de la défausse et la zone de la pioche
	 */
	private JPanel croupierPanel;
	/**
	 * playerPanel zone regroupant les joueurs (joueur + bot(s))
	 */
	private JPanel playerPanel;
	/**
	 * buttonPanel zone regroupant les boutons 
	 */
	private JPanel buttonPanel;
	/**
	 *  discard zone de la défausse
	 */
	private JPanel discard;
	/**
	 * boxPanel zone regroupant la zone du croupier, la zone des joueurs ainsi que la zone des boutons
	 */
	private JPanel boxPanel;
	/** intialisation de l'affichage
	 * */
	
	
	public Window() {

		super("Jeu de Blackjack");

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

      	// Panels

		this.pullButton = new JPanel();
		this.stopButton = new JPanel();

		this.discard = new JPanel();
		this.croupier = new JPanel();
		this.draw = new JPanel();

		this.player = new JPanel();
		this.bot1 = new JPanel();
		this.bot2 = new JPanel();

		this.croupierPanel = new JPanel();
		this.playerPanel = new JPanel();
		this.buttonPanel = new JPanel();

		this.boxPanel = new JPanel();


		// Setting layouts to the panels

      	this.pullButton.setLayout(new GridLayout(1, 1));
      	this.stopButton.setLayout(new GridLayout(1, 1));

      	this.discard.setLayout(new GridLayout(1, 1));
      	this.croupier.setLayout(new GridLayout(1, 1));
      	this.draw.setLayout(new GridLayout(1, 1));

      	this.player.setLayout(new GridLayout(1, 1));
      	this.bot1.setLayout(new GridLayout(1, 1));
      	this.bot2.setLayout(new GridLayout(1, 1));

      	this.croupierPanel.setLayout(new BoxLayout(this.croupierPanel, BoxLayout.X_AXIS));
        this.playerPanel.setLayout(new BoxLayout(this.playerPanel, BoxLayout.X_AXIS));
        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.X_AXIS));

        this.boxPanel.setLayout(new BoxLayout(this.boxPanel, BoxLayout.Y_AXIS));

        this.setLayout(new FlowLayout());

      	// Setting borders to the panels

      	this.pullButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
      	this.stopButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

      	this.discard.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      	this.croupier.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      	this.draw.setBorder(BorderFactory.createLineBorder(Color.black, 1));

      	this.player.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      	this.bot1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      	this.bot2.setBorder(BorderFactory.createLineBorder(Color.black, 1));

      	this.croupierPanel.setBorder(BorderFactory.createTitledBorder("Partie croupier"));
        this.playerPanel.setBorder(BorderFactory.createTitledBorder("Partie Joueur(s)"));
        this.buttonPanel.setBorder(BorderFactory.createTitledBorder("Partie bouton pour le(s) joueur(s)"));

        this.boxPanel.setBorder(BorderFactory.createTitledBorder("Jeu Blackjack"));


        // Adding to the panels

        this.croupierPanel.add(this.discard);
        this.croupierPanel.add(this.croupier);
        this.croupierPanel.add(this.draw);

        this.playerPanel.add(this.player);
        this.playerPanel.add(this.bot1);
        this.playerPanel.add(this.bot2);

        this.buttonPanel.add(this.pullButton);
        this.buttonPanel.add(this.stopButton);

        this.boxPanel.add(this.croupierPanel);
        this.boxPanel.add(this.playerPanel);
        this.boxPanel.add(this.buttonPanel);


        // Adding panels to the contentPane

      	this.add(this.pullButton);
      	this.add(this.stopButton);

      	this.add(this.discard);
      	this.add(this.croupier);
      	this.add(this.draw);

      	this.add(this.player);
      	this.add(this.bot1);
      	this.add(this.bot2);

      	// Setting alignments and adding to the panels

      	pullButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      	stopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      	buttonPanel.add(pullButton);
      	buttonPanel.add(stopButton);

        discard.setAlignmentX(Component.CENTER_ALIGNMENT);
        croupier.setAlignmentX(Component.CENTER_ALIGNMENT);
        draw.setAlignmentX(Component.CENTER_ALIGNMENT);
        croupierPanel.add(discard);
        croupierPanel.add(croupier);
        croupierPanel.add(draw);

        player.setAlignmentX(Component.CENTER_ALIGNMENT);
        bot1.setAlignmentX(Component.CENTER_ALIGNMENT);
        bot2.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerPanel.add(player);
        playerPanel.add(bot1);
        playerPanel.add(bot2);

        boxPanel.add(croupierPanel);
        boxPanel.add(playerPanel);
        boxPanel.add(buttonPanel);


        // Adding panels to the contentPane

        this.add(this.boxPanel);


        croupierPanel.setPreferredSize(new Dimension(500,250));
        playerPanel.setPreferredSize(new Dimension(500,250));




        // addition of the action panel

        JButton pullButton = new JButton("Tirer");
        JButton stopButton = new JButton("Stop");


        pullButton.setPreferredSize(new Dimension(200,52));
        stopButton.setPreferredSize(new Dimension(200,52));


        this.pullButton.add(pullButton);
        this.stopButton.add(stopButton);



	}

	/**affiche un packet de carte de taille N (packet de la pioche)
	 * @param nCard le nombre de carte de la pioche */
	public void ViewDeck(String nCard) {
		JLabel nombreDeCarte = new JLabel(nCard);
		this.draw.add(nombreDeCarte);
	}
/*
	//affiche les carte du croupier /!\ la valeur boolean indique si l'on peux voir les cartes du croupier ou pas. (on ne vois que la permi�re carte de sont jeux)
	public void ViewDeckCroupier(Arrays liste,boolean variable) {
		if (variable == true) {
			this.croupier.tirer(liste[1], liste[1]);
		}
		else {
			this.croupier.tirer("hide", "hide");
		}
	}

	//affiche les carte des joueur (bot)  /!\ recois une liste de liste forme [(-,-,-,),(-,-,-,),(-,-,-,)] on dit qu'il y a max 2 bot pour simplifier
	public void ViewBotDeck(ArrayList<model_IA_Blackjack> bot) {

		for(int i = 1; i <= bot.length(); i++) {
			this.bot.getPaquet();

			for(int i = 1; i <= this.paquet.getLength(); i++) {
				this.bot1.paquet.getGetcarte[i];
			}
		}

	}*/

}
