package mvc.modele.allumettes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Random;

public class ImplAllumettes extends UnicastRemoteObject implements InterfaceAllumettes {

	HashMap<Integer, PartieAllumettes> listePartie = new HashMap<Integer, PartieAllumettes>();

	int idPartie = 0;

	private int nombreAllumettes;

	public ImplAllumettes() throws RemoteException {
		super();
		nombreAllumettes = generationAleatoireAllumettes();
	}

	@Override
	public int coupIA() throws RemoteException {
		Random coupOrdi = new Random();
		int r = coupOrdi.nextInt();

		return r;
	}

	@Override
	public int generationAleatoireAllumettes() throws RemoteException {

		int nbAllumettesPartie = new Random().nextInt(12) + 7; // genere un nombre d'allumettes entre 7 et 19
		if (nbAllumettesPartie % 2 == 0) {
			nbAllumettesPartie++;

		}
		return nbAllumettesPartie;
	}

	@Override
	public void soustraireAllumettes(int id, int nbRetirer) throws RemoteException {
		int nbAllumette = listePartie.get(id).getNbAllumettesPartie();
		nbAllumette -= nbRetirer;
		listePartie.get(id).setNbAllumettesPartie(nbAllumette);
	}

	@Override
	public String partieTerminee(int resultat) throws RemoteException {

		return null;
	}

	@Override
	public int getNombreAllumettesJoueur(int id) throws RemoteException {

		return listePartie.get(id).getNbAllumetteJoueur();
	}

	@Override
	public int getNbAllumettePartie(int id) throws RemoteException {

		return listePartie.get(id).getNbAllumettesPartie();
	}

	@Override
	public int nouvellePartie() throws RemoteException {
		idPartie++;
		PartieAllumettes nouvellePartie = new PartieAllumettes();
		listePartie.put(idPartie, nouvellePartie);

		return idPartie;
	}

}
