package mvc.modele.pendu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@SuppressWarnings("serial")
public class ImplPendu extends UnicastRemoteObject implements InterfacePendu {

	HashMap<Integer, PartiePendu> listePartie = new HashMap<Integer, PartiePendu>();

	public ImplPendu() throws RemoteException {
		super();
		listeErreurs = new ArrayList<Integer>();
		listeErreurs.add(0);
	}

	String dictionnaire[] = { "claire", "waian", "valentin" };
	int nbErreurs = 0;
	int idPartie = 0;
	ArrayList<Integer> listeErreurs;

	@Override
	public void setMotCache(int id, char[] mot) throws RemoteException {
		listePartie.get(id).setMotCache(mot);
	}

	// le getMotCache se fait dans affichage
	@Override
	public String affichage(int id) {
		String motAffichage = "";
		char[] motCache = listePartie.get(id).getMotCache();
		for (int i = 0; i < motCache.length; i++) {
			motAffichage += motCache[i];
			motAffichage += " ";
		}
		return motAffichage;
	}

	@Override
	public void generationMotAleatoire(int id) throws RemoteException {
		String mot = "";
		Random nbAleatoire = new Random();
		mot = dictionnaire[nbAleatoire.nextInt(dictionnaire.length)];
		listePartie.get(id).setMot(mot);
	}

	@Override
	public String getMotAleatoire(int id) throws RemoteException {
		return listePartie.get(id).getMot();
	}

	@Override
	public void ecritLettres(int id, char lettre) throws RemoteException {
		boolean trouve = false;
		String mot = listePartie.get(id).getMot();
		char[] motCache = listePartie.get(id).getMotCache();

		for (int i = 0; i < mot.length(); i++) {
			if (mot.charAt(i) == lettre) {
				System.out.println("mot : " + mot + ", lettre : " + lettre);
				motCache[i] = mot.toUpperCase().charAt(i);
				trouve = true;
			}
		}
		if (trouve == false) {
			int nbErreurs = listePartie.get(id).getNbErreurs();
			listePartie.get(id).setNbErreurs(nbErreurs + 1);
			System.out.println("Partie n°" + id + ", nombre erreurs : " + listePartie.get(id).getNbErreurs());
		}
		listePartie.get(id).setMotCache(motCache);

	}

	// dessinerPendu alias getNbErreurs
	@Override
	public int dessinerPendu(int id) throws RemoteException {
		return listePartie.get(id).getNbErreurs();
	}

	@Override
	public void setNombreErreurs(int id, int nb) throws RemoteException {
		listePartie.get(id).setNbErreurs(nb);
	}

	public boolean partieTerminee(int id) throws RemoteException {
		boolean trouve = true; 
		int i=0; 
		if (listePartie.get(id).getNbErreurs()>=11)
			trouve = true;  
		else {
			while ((trouve == true) && (i<listePartie.get(id).mot.length())) {
				if (listePartie.get(id).mot.toUpperCase().charAt(i) != listePartie.get(id).motCache[i]) 
					trouve = false; 
				i++; 
			}
		}
		return trouve; 
	}

	@Override
	public int nouvellePartie() throws RemoteException {
		idPartie++;
		PartiePendu nouvellePartie = new PartiePendu();
		listePartie.put(idPartie, nouvellePartie);

		return idPartie;
	}

}
