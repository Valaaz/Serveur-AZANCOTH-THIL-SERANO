package rmi;

//LE SERVEUR HELLO
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
	public static void main(String[] argv) {
		try {
			int port = 8000;
			// Naming.rebind ("hello", new HelloImpl());
			LocateRegistry.createRegistry(port);
			Naming.rebind("rmi://localhost:" + port + "/hello", new JeuImpl());
			System.out.println("Hello Server prêt !");
		} catch (Exception e) {
			System.out.println("Hello Server échec " + e);
		}
	}
}
