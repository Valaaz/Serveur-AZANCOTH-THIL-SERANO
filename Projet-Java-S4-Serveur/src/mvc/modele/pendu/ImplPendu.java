package mvc.modele.pendu;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class ImplPendu extends UnicastRemoteObject implements InterfacePendu {

	public ImplPendu() throws RemoteException {
		super();
		listeErreurs = new ArrayList<Integer>();
		listeErreurs.add(0);
	}

	String dictionnaire[] = {"claire", "waian", "valentin"};
	int nbErreurs = 0; 
	int idPartie = 0;
	ArrayList<Integer> listeErreurs;
	
	@Override 
	public String affichage(char[] motCache) {
		String motAffichage = ""; 
		for (int i =0; i<motCache.length;i++) {
			motAffichage += motCache[i]; 
			motAffichage += " "; 
		}
		return motAffichage; 
	}
	
	@Override
	public String generationMotAleatoire() throws RemoteException {
		String mot = "";
		Random nbAleatoire = new Random();
		mot = dictionnaire[nbAleatoire.nextInt(dictionnaire.length)];
		return mot;
	}

	
	@Override
	public char[] ecritLettres(String mot, char lettre, char[] motCache) throws RemoteException {
		boolean trouve = false; 
		for (int i=0; i<mot.length(); i++) {
			if (mot.charAt(i) == lettre) {
				motCache[i] = mot.toUpperCase().charAt(i);  
				trouve = true;
			}
		}
		if (trouve == false) nbErreurs++; //listeErreurs.set(idPartie, listeErreurs.get(idPartie) + 1);
		return motCache; 
	}
	
	public int dessinerPendu() throws RemoteException {
		return nbErreurs; 
	}

	/*
	@Override
	public int dessinerPendu(int idPartie) throws RemoteException {
		System.out.println(idPartie);
		System.out.println(listeErreurs.get(idPartie));
		return listeErreurs.get(idPartie); 
	}
	
	@Override
	public boolean partieTerminee (int idPartie) {
		return false; 
	}
	
	@Override
    public int nouvellePartie() {
        idPartie++; 
        return idPartie; 
    }
	*/

}
