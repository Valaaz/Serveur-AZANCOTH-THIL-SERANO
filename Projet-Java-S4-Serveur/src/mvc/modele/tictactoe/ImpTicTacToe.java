package mvc.modele.tictactoe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ImpTicTacToe extends UnicastRemoteObject implements InterfaceTicTacToe {

	int idPartie = 1;
	HashMap<Integer, InterfaceTicTacToe> listePartie = new HashMap<Integer, InterfaceTicTacToe>();

	public ImpTicTacToe() throws RemoteException {
		super();
	}

	@Override
	public String echo() throws RemoteException {
		return "Bienvenue sur le serveur de jeu !!";
	}

	@Override
	public int numPartie() {
		// listePartie.put(idPartie, null);
		return idPartie++;
	}
}
