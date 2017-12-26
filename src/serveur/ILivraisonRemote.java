package serveur;

import java.rmi.RemoteException;

public interface ILivraisonRemote extends IStock {
	
	public int livrer(int quantité) throws RemoteException;
	public  int getValLivraison() throws RemoteException;
	
}
