package Carte;
import java.util.*;   
/** classe factory permettant de construre un paquet de carte. 
 * @author 21903309
 * */
public class factory { 
	//liste array
	static String [] couleurs = {"carreau","trefle", "pique", "coeur" };
    static String [] type52 = {"as","2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "dame", "roi"};
    static String [] type32 = {"as","7", "8", "9", "10", "valet", "dame", "roi"};
    
   /**
    * 
    * @return renvoie un paque de 52 carte (52 objet carte) 
    * construction d'un paquet de carte de 52 carte
    * @see MakeCarte#MakeCarte(String c, String t)
    * @see Paquet#Paquet()
    */
    
    public static Paquet makeDeck52(){ 
    	ArrayList<MakeCarte> Enssemble = new ArrayList<MakeCarte>();
    	
    	for (String c : couleurs) {
    		for (String t : type52) {
    			MakeCarte carte = new MakeCarte(c,t);
    			Enssemble.add(carte);
    		}
    	}
    	
    	Paquet paquet= new Paquet(Enssemble);	
    	return paquet;
    }
    /**
     * @return renvoie un paque vide 
     * methode de construction d'un paquet vide
     * @see MakeCarte#MakeCarte(String c, String t)
     * @see Paquet#Paquet()
     */
    public static Paquet makeEmptydeck() {
    	ArrayList<MakeCarte> Enssemble = new ArrayList<MakeCarte>();
    	Paquet paquet= new Paquet(Enssemble);	
    	return paquet;
    }
    /**
     * @return renvoie un paque de 32 carte (32 objet carte) 
     * methode de construction d'un paquet de carte de 32 carte
     * @see MakeCarte#MakeCarte(String c, String t)
     * @see Paquet#Paquet()
     */
   public static Paquet makeDeck32(){//contruction d'un paquet de 32 cartes
    	ArrayList<MakeCarte> Enssemble = new ArrayList<MakeCarte>();
    	
    	for (String c : couleurs) {
    		for (String t : type32) {
    			MakeCarte carte = new MakeCarte(c,t);
    			Enssemble.add(carte);
    		}
    	}
    	Paquet paquet = new Paquet(Enssemble);
    	return paquet;
    }
   /**
    * @param Npaquet indique le nombre de paque voulus
    * @return renvoie un paque de N fois 52 cartes 
    * methode par defaut de makeNpaquetWithDeck d'un paquet de N carte.(ici par defaut des paquet de 52 carte).
    * Permet de cumule plusieur paque dans un seul paque
    * soit: 4 paque de 52 carte enssemble, forme un paque de 208 cartes
    * @see MakeCarte#MakeCarte(String c, String t)
    * @see Paquet#Paquet()
    */
   public static Paquet makeNpaquetWithDeck(int Npaquet) {//methode permettant de contruire une liste de N * 52 carte
    	ArrayList<MakeCarte> Enssemble = new ArrayList<MakeCarte>();
		for (int i= 0; i<=Npaquet; i++) {
	    	for (String c : couleurs) {
	    		for (String t : type52) {
	    			MakeCarte carte = new MakeCarte(c,t);
	    			Enssemble.add(carte);
	    		}
	    	}
		}
	    	Paquet paquet = new Paquet(Enssemble);
	    	return paquet;
    }
    //produit N paquet de 32 ou 52 carte (si la valeur est differente de 32 alor le paquet cera de 52 carte)
   
   /**
    * @param Npaquet indique le nombre de paque voulus
    * @param value indite le type de paque souaite (soit 32, soit 52 cates).
    * @return renvoie un paque de N fois 52 ou 32 cartes 
    * methode makeNpaquetWithDeck d'un paquet de N carte.
    * avec un choix de quelle type de paque l'on souaite utilise (soit 32 soit 52 cartes).
    * Permet de cumule plusieur paque dans un seul paque
    * soit: 4 paque de 52 carte enssemble, forme un paque de 208 cartes
    * @see MakeCarte#MakeCarte(String c, String t)
    * @see Paquet#Paquet()
    */
    
   public static Paquet makeNpaquetWithDeck(int Npaquet, int value){//
    	ArrayList<MakeCarte> Enssemble = new ArrayList<MakeCarte>();
    	if (value == 32) {
        	for (int i= 0; i<=Npaquet; i++) {
    	    	for (String c : couleurs) {
    	    		for (String t : type32) {
    	    			MakeCarte carte = new MakeCarte(c,t);
    	    			Enssemble.add(carte);
    	    		}
    	    	}
        	}
    	}else if(value == 52){
    		for (int i= 0; i<=Npaquet; i++) {
    	    	for (String c : couleurs) {
    	    		for (String t : type52) {
    	    			MakeCarte carte = new MakeCarte(c,t);
    	    			Enssemble.add(carte);
    	    		}
    	    	}
        	}
    	}else {
    		System.out.println("erreur value, la valeur doit être soit 32 soit 52");
    	}
    	
    	Paquet paquet = new Paquet(Enssemble);
    	return paquet;
    }
    
}
