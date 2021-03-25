package mvc.modele.allumettes;

public class PartieAllumettes {

	private int nbAllumettesPartie = 0;
	private int nbAllumetteJoueur = 0;
	private int tour = 1;

	public int getNbAllumettesPartie() {
		return nbAllumettesPartie;
	}

	public void setNbAllumettesPartie(int nbAllumettesPartie) {
		this.nbAllumettesPartie = nbAllumettesPartie;
	}

	public int getNbAllumetteJoueur() {
		return nbAllumetteJoueur;
	}

	public void setNbAllumetteJoueur(int nbAllumetteJoueur) {
		this.nbAllumetteJoueur = nbAllumetteJoueur;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

}
