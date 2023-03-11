package Carte;
import java.util.*;
/** classe Paquet qui permet de definir un paquet de carte
 * @author 21903309
 * */
public class Paquet {
	ArrayList<MakeCarte> paquet;
    /**
     * @param liste Liste de carte
     * Constructeur d'un paquet de carte
     * Permet d'initialise le paquet.
     * @see MakeCarte#MakeCarte(String c, String t)
     */
	public Paquet(ArrayList<MakeCarte> liste) {
		this.paquet= liste;
	}
    /**
     * Constructeur d'un paquet de carte vide
     * 
     */
	public Paquet() {

	    if (this.paquet.isEmpty()) {
	        System.out.println("Le paquet est vide");
	    } else {
	        System.out.println("Erreur le paquet en replie");
	    }
	}
	
    /**
     * @param value Prend une carte 
     * Permet d'ajouter une carte au debut du paquet
     */
	
	public void addcartOnTop(MakeCarte value){ //ajoute une carte au debut
		this.paquet.add(0,value);
	}
	
    /**
     * @param value Prend une carte 
     * Permet d'ajouter une carte à la fin du paquet
     */
	public void addcartOnBot(MakeCarte value){ //ajoute une carte a la fin
		this.paquet.add(value);
	}	
    /**
     * Permet de supprimer la première carte du paquet 
     */
	public void removeFirstCarte() { // supprime la première carte
		this.paquet.remove(0);
	}
    /**
     * @param index Prend un int en entre 
     * Permet de supprimer un element de la liste selon un index int
     */
	public void removeIndex(int index) { // supprime lelement demande
		this.paquet.remove(index);
	}
    /**
     * Permet de melange le paquet
     */
	public void mixpaquet() { //melange
		Collections.shuffle(this.paquet);
	}
    /**
     * @param index Prend un int en entre 
     * Permet d'obtenir une carte
     * @return renvoie la carte demande
     */
	public MakeCarte getGetcarte(int index) { //renvoie l'element demande
		return this.paquet.get(index);
	}
    /**
     * @param objet Prend en entre un objet carte
     * Verifie si une carte existe dans le paquet
     * @return renvoie true ou false
     * @see MakeCarte#MakeCarte(String c, String t)
     */
	public boolean getExists(MakeCarte objet) { //renvoie true si l'elemenet existe
		return this.paquet.contains(objet);
	}
    /**
     * Permet de savoir combien il y a de carte dans le paquet
     * @return un int
     * @see MakeCarte#MakeCarte(String c, String t)
     */	
	public int getlength() { //erenvoie le nombre delement du paquet
		return this.paquet.size();
	}
    /**
     * @param var String as....10,valet,dame,roi
     * permet de savoir si un type exit dans le paquet
     * @return un boolean true si existe false sinon
     * @see MakeCarte#MakeCarte(String c, String t)
     */	
	public boolean getExistsByType(String var) {
		MakeCarte carte;
		for(int i=1;i<=this.getlength();i++) {
			carte=this.getGetcarte(i);
			if(carte.getType().equals(var)==true) {
				return true;
			}
		}
		return false;
	}
    /**
     * @param var prend un string d'une couleur comme Carreau
     * permet de savoir si une couleur existe dans le paquet
     * @return un boolean true si existe false sinon
     * @see MakeCarte#MakeCarte(String c, String t)
     */
	public boolean getExistsBycolor(String var) {

		MakeCarte carte;
		for(int i=1;i<=this.getlength();i++) {
			carte=this.getGetcarte(i);
			if(carte.getCouleur().equals(var)) {
				return true;
			}
		}
		return false;
	}
    /**
     * @param i int d'index de la carte recherché
     * @param var String as....10,valet,dame,roi
     * permet de savoir si un type exit dans le paquet
     * @return un boolean true si existe false sinon
     * @see MakeCarte#MakeCarte(String c, String t)
     */	
	public boolean getExistsByTypeByIndex(int i,String var) {
		if (this.paquet.get(i).getType().equals(var)==true) {
			return true;
		}
		return false;
	}
}
