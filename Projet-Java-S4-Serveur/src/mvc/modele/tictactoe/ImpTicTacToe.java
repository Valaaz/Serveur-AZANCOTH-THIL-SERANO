package mvc.modele.tictactoe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ImpTicTacToe extends UnicastRemoteObject implements InterfaceTicTacToe {

	int idPartie = 1;
	HashMap<Integer, PartieTicTacToe> listePartie = new HashMap<Integer, PartieTicTacToe>();
	ArrayList<Integer> listeJoueur = new ArrayList<Integer>();

	public ImpTicTacToe() throws RemoteException {
		super();
	}

	@Override
	public int numPartie() throws RemoteException {
		Set<Integer> listKeys = listePartie.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			Object key = iterateur.next();
			if (listePartie.get(key).getNbJoueur() != 2) {
				return (int) key;
			}
		}

		PartieTicTacToe nouvellePartie = new PartieTicTacToe();
		listePartie.put(idPartie, nouvellePartie);

		return idPartie++;
	}

	@Override
	public int getNombreJoueur(int id) throws RemoteException {
		return listePartie.get(id).getNbJoueur();
	}

	@Override
	public void setNombreJoueur(int id, int joueur) throws RemoteException {
		listePartie.get(id).setNbJoueur(joueur);
	}

	@Override
	public int getTourActuel(int id) throws RemoteException {
		return listePartie.get(id).getTour();
	}

	@Override
	public void setTourActuel(int id, int tour) throws RemoteException {
		listePartie.get(id).setTour(tour);
	}

	@Override
	public String getFormeActuel(int id) throws RemoteException {
		return listePartie.get(id).getForme();
	}

	@Override
	public void setFormeActuel(int id, String forme) throws RemoteException {
		listePartie.get(id).setForme(forme);
	}

	@Override
	public String[] getLabels(int id) throws RemoteException {
		return listePartie.get(id).getTabLabel();
	}

	@Override
	public void setLabels(int id, String[] l) throws RemoteException {
		listePartie.get(id).setTabLabel(l);
	}

	@Override
	public boolean verificationVictoire(int idPartie, int tour, String l1, String l2, String l3, String l4, String l5,
			String l6, String l7, String l8, String l9) throws RemoteException {

		System.out.println("Forme : " + getFormeJoue(idPartie) + ", l1 : " + l1 + ", l2 : " + l2 + ", l3 : " + l3
				+ ", l4 : " + l4 + ", l5 : " + l5 + ", l6 : " + l6 + ", l7 : " + l7 + ", l8 : " + l8 + ", l9 : " + l9);

		if (l1.equals(getFormeJoue(idPartie)) && l2.equals(getFormeJoue(idPartie))
				&& l3.equals(getFormeJoue(idPartie))) {
			System.out.println("Victoire des " + getFormeJoue(idPartie) + " !!");
			return true;
		}
		if (l4.equals(getFormeJoue(idPartie)) && l5.equals(getFormeJoue(idPartie))
				&& l6.equals(getFormeJoue(idPartie))) {
			System.out.println("Victoire des " + getFormeJoue(idPartie) + " !!");
			return true;
		}
		if (l7.equals(getFormeJoue(idPartie)) && l8.equals(getFormeJoue(idPartie))
				&& l9.equals(getFormeJoue(idPartie))) {
			System.out.println("Victoire des " + getFormeJoue(idPartie) + " !!");
			return true;
		}
		if (l1.equals(getFormeJoue(idPartie)) && l4.equals(getFormeJoue(idPartie))
				&& l7.equals(getFormeJoue(idPartie))) {
			System.out.println("Victoire des " + getFormeJoue(idPartie) + " !!");
			return true;
		}
		if (l2.equals(getFormeJoue(idPartie)) && l5.equals(getFormeJoue(idPartie))
				&& l8.equals(getFormeJoue(idPartie))) {
			System.out.println("Victoire des " + getFormeJoue(idPartie) + " !!");
			return true;
		}
		if (l3.equals(getFormeJoue(idPartie)) && l6.equals(getFormeJoue(idPartie))
				&& l9.equals(getFormeJoue(idPartie))) {
			System.out.println("Victoire des " + getFormeJoue(idPartie) + " !!");
			return true;
		}
		if (l1.equals(getFormeJoue(idPartie)) && l5.equals(getFormeJoue(idPartie))
				&& l9.equals(getFormeJoue(idPartie))) {
			System.out.println("Victoire des " + getFormeJoue(idPartie) + " !!");
			return true;
		}
		if (l7.equals(getFormeJoue(idPartie)) && l5.equals(getFormeJoue(idPartie))
				&& l3.equals(getFormeJoue(idPartie))) {
			System.out.println("Victoire des " + getFormeJoue(idPartie) + " !!");
			return true;
		}
		return false;
	}

	@Override
	public boolean verificationMatchNul(int idPartie, String l1, String l2, String l3, String l4, String l5, String l6,
			String l7, String l8, String l9) throws RemoteException {
		if (l1 != "" && l2 != "" && l3 != "" && l4 != "" && l5 != "" && l6 != "" && l7 != "" && l8 != "" && l9 != "") {
			System.out.println("Match nul !!");
			return true;
		}

		return false;
	}

	@Override
	public String getFormeJoue(int id) throws RemoteException {
		int tour = listePartie.get(id).getTour() - 1;

		if (tour == 1)
			return "X";
		else
			return "O";
	}

	@Override
	public String initialisation() throws RemoteException {
		String labelVide = "";
		return labelVide;

	}

}
