package mvc.modele;

//Impl�mentation de l'interface Hello
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JeuImpl extends UnicastRemoteObject implements JeuInterface {
	public JeuImpl() throws RemoteException {
		super();
	}

	@Override
	public String echo() throws RemoteException {
		return "Bienvenue sur le serveur de jeu !!";
	}
}