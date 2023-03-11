package Carte;
/** class definisant une carte
 * @author 21903309
 * */
public class MakeCarte { 
	String couleur;
	String type;
	/** 
	 * @param c nom de la couelur
	 * @param t nom du type
	 * constructeur de la carte prennant en entre une couleur et une type ('carreau','pique','trefle','coeur').
	 * */
    public MakeCarte(String c, String t) { 
        this.couleur = c;
        this.type = t;
    }
    /** 
     * @return renvoie un text contenant les valeur de la carte
     * re definition de toString pour afficher ce qu'est la carte.
     * */
	@Override
	public String toString() { 
		return "Carte [couleur=" + couleur + ", type=" + type + "]";
	}
	/** 
	 * @return renvoie la couleur de la carte
	 * axcesseur de la couleur de la carte
	 * */
	public String getCouleur() { 
		return couleur;
	}

	/** 
	 * @return renvoie le type de la carte
	 * axcesseur du type de la carte ('carreau','pique','trefle','coeur').
	 * */
	public String getType() { 
		return type;
	}

    
}
