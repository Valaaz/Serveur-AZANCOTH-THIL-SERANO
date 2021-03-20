package mvc.modele.pendu;

public class PartiePendu {

	String mot;
	char[] motCache;
	int nbErreurs = 0;
	int idPartie = 1;

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public char[] getMotCache() {
		return motCache;
	}

	public void setMotCache(char[] motCache) {
		this.motCache = motCache;
	}

	public int getNbErreurs() {
		return nbErreurs;
	}

	public void setNbErreurs(int nbErreurs) {
		this.nbErreurs = nbErreurs;
	}

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}

}
