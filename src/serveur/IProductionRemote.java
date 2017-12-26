package serveur;

import java.rmi.RemoteException;

public interface IProductionRemote extends IStock {

	public   int stocker(int s) throws RemoteException;
	public int getValstock() throws RemoteException;
}
