package mvc.modele.allumettes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Random;

public class ImplAllumettes extends UnicastRemoteObject implements InterfaceAllumettes {

	HashMap<Integer, PartieAllumettes> listePartie = new HashMap<Integer, PartieAllumettes>();

	int idPartie = 0;

	public ImplAllumettes() throws RemoteException {
		super();

	}

	@Override
	public void coupIA(int id) throws RemoteException {
		int r;
		int nbAllumettes = getNbAllumettePartie(id);
		if (nbAllumettes == 1) {
			r = 1;
		} else {
			Random coupOrdi = new Random();
			r = coupOrdi.nextInt(2) + 1;
		}

		setNbAllumettePartie(id, nbAllumettes - r);

	}

	@Override
	public int getTour(int id) throws RemoteException {
		return listePartie.get(id).getTour();
	}

	@Override
	public void setTour(int id, int tour) throws RemoteException {
		listePartie.get(id).setTour(tour);
	}

	@Override
	public int generationAleatoireAllumettes(int id) throws RemoteException {

		int nbAllumettesPartie = new Random().nextInt(12) + 7; // genere un nombre d'allumettes entre 7 et 19
		if (nbAllumettesPartie % 2 == 0) {
			nbAllumettesPartie++;

		}

		return nbAllumettesPartie;
	}

	@Override
	public void soustraireAllumettes(int id, int nbRetirer) throws RemoteException {
		int nombreAllumette = listePartie.get(id).getNbAllumettesPartie();
		nombreAllumette -= nbRetirer;
		setNbAllumettePartie(id, nombreAllumette);

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
	public void setNombreAllumettesJoueur(int id, int nbAllumettesJoueur) throws RemoteException {
		listePartie.get(id).setNbAllumetteJoueur(nbAllumettesJoueur);
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

	@Override
	public void setNbAllumettePartie(int id, int nbAllumettes) throws RemoteException {
		listePartie.get(id).setNbAllumettesPartie(nbAllumettes);

	}

}
