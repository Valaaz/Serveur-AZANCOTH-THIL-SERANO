package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import mvc.modele.tictactoe.ImpTicTacToe;

public class Serveur {
	public static void main(String[] argv) {
		try {
			int port = 8000;
			LocateRegistry.createRegistry(port);

			// ImpPendu pendu = new ImpPendu();
			// Naming.rebind("rmi://localhost:" + port + "/pendu", pendu);

			// ImpAllumettes allumette = new ImpAllumettes();
			// Naming.rebind("rmi://localhost:" + port + "/allumette", allumette);

			ImpTicTacToe tictactoe = new ImpTicTacToe();
			Naming.rebind("rmi://localhost:" + port + "/hello", tictactoe);

			System.out.println("Serveur de jeu prêt !");
		} catch (Exception e) {
			System.out.println("Serveur de jeu échec " + e);
		}
	}

}
