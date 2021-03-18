package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

<<<<<<< Updated upstream
import mvc.modele.tictactoe.ImpTicTacToe;
=======
import mvc.modele.JeuImpl;
import mvc.modele.pendu.ImplPendu;
>>>>>>> Stashed changes

public class Serveur {
	public static void main(String[] argv) {
		try {
			int port = 8000;
			LocateRegistry.createRegistry(port);

<<<<<<< Updated upstream
			// ImpPendu pendu = new ImpPendu();
			// Naming.rebind("rmi://localhost:" + port + "/pendu", pendu);
=======
			ImplPendu pendu = new ImplPendu();
			Naming.rebind("rmi://localhost:" + port + "/pendu", pendu);
>>>>>>> Stashed changes

			// ImpAllumettes allumette = new ImpAllumettes();
			// Naming.rebind("rmi://localhost:" + port + "/allumette", allumette);

<<<<<<< Updated upstream
			ImpTicTacToe tictactoe = new ImpTicTacToe();
			Naming.rebind("rmi://localhost:" + port + "/tictactoe", tictactoe);
=======
			//ImpTicTacToe tictactoe = new ImpTicTacToe();
			//Naming.rebind("rmi://localhost:" + port + "/tictactoe", tictactoe);
>>>>>>> Stashed changes

			System.out.println("Serveur de jeu prêt !");
		} catch (Exception e) {
			System.out.println("Serveur de jeu échec " + e);
		}
	}

}
