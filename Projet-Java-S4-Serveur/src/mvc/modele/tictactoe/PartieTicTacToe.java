package mvc.modele.tictactoe;

public class PartieTicTacToe {

	private int idPartie = 1;
	private int nbJoueur = 0;
	String[] tabLabel;

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}

	public int getNbJoueur() {
		return nbJoueur;
	}

	public void setNbJoueur(int nbJoueur) {
		this.nbJoueur = nbJoueur;
	}

	public String[] getTabLabel() {
		return tabLabel;
	}

	public void setTabLabel(String[] tabLabel) {
		this.tabLabel = tabLabel;
	}

}
