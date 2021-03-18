package mvc.modele.pendu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

@SuppressWarnings("serial")
public class ImplPendu extends UnicastRemoteObject implements InterfacePendu{
	
	public ImplPendu () throws RemoteException {
		super(); 
	}
	
	String dictionnaire[] = {"Claire", "Valentin", "Waian"}; 
	
	@Override
	public String generationMotAleatoire() throws RemoteException {
		String mot=""; 
		Random nbAleatoire = new Random();
		mot = dictionnaire[nbAleatoire.nextInt(dictionnaire.length)];
		return mot; 
	}
	
	@Override
	public char ecritLettres (char c) throws RemoteException {
		return c; 
	}
	
	@Override
	public void dessinerPendu() throws RemoteException {
		
	}

}
