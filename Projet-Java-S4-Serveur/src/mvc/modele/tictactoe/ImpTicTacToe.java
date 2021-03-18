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
	public boolean verificationVictoire(int idPartie, int tour, String l1, String l2, String l3, String l4, String l5,
			String l6, String l7, String l8, String l9) throws RemoteException {

		if (l1.equals(getForme(tour)) && l2.equals(getForme(tour)) && l3.equals(getForme(tour))) {
			System.out.println("Victoire des " + getForme(tour) + " !!");
			return true;
		}
		if (l4.equals(getForme(tour)) && l5.equals(getForme(tour)) && l6.equals(getForme(tour))) {
			System.out.println("Victoire des " + getForme(tour) + " !!");
			return true;
		}
		if (l7.equals(getForme(tour)) && l8.equals(getForme(tour)) && l9.equals(getForme(tour))) {
			System.out.println("Victoire des " + getForme(tour) + " !!");
			return true;
		}
		if (l1.equals(getForme(tour)) && l4.equals(getForme(tour)) && l7.equals(getForme(tour))) {
			System.out.println("Victoire des " + getForme(tour) + " !!");
			return true;
		}
		if (l2.equals(getForme(tour)) && l5.equals(getForme(tour)) && l8.equals(getForme(tour))) {
			System.out.println("Victoire des " + getForme(tour) + " !!");
			return true;
		}
		if (l3.equals(getForme(tour)) && l6.equals(getForme(tour)) && l9.equals(getForme(tour))) {
			System.out.println("Victoire des " + getForme(tour) + " !!");
			return true;
		}
		if (l1.equals(getForme(tour)) && l5.equals(getForme(tour)) && l9.equals(getForme(tour))) {
			System.out.println("Victoire des " + getForme(tour) + " !!");
			return true;
		}
		if (l7.equals(getForme(tour)) && l5.equals(getForme(tour)) && l3.equals(getForme(tour))) {
			System.out.println("Victoire des " + getForme(tour) + " !!");
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

	public String getForme(int tour) {
		tour--; // On décremente le tour de 1 car on l'incrémente dans la fonction poseForme()
				// et nous voulons récupérer le tour qui a été joué
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
