package serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class accesLivraison extends UnicastRemoteObject implements ILivraisonRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int valAncienneLivraison = 0;

	protected accesLivraison() throws RemoteException {
		super();

	}

	@Override
	public int getValLivraison() throws RemoteException {

		return this.valAncienneLivraison;
	}

	public int getValLivraisonx() {
		return this.valAncienneLivraison;
	}

	public boolean preLivrer(int valLivraisonNouvelle) throws RemoteException {

		try {
			IProductionRemote objetProduction = (IProductionRemote) Naming.lookup("Production");

			if (objetProduction.getValstock() - (valAncienneLivraison + valLivraisonNouvelle) >= 0) {
				System.out.println("Quantité  du stock est:" + objetProduction.getValstock());
				return true;
			} else {
				System.out.println("stock vide");
				return false;
			}

		} catch (MalformedURLException | NotBoundException e) {

			e.printStackTrace();
		}
		return false;

	}

	@Override
	public int livrer(int valLivraisonNouvelle) throws RemoteException {

		if (preLivrer(valLivraisonNouvelle) == true) {

			valAncienneLivraison += valLivraisonNouvelle;

			System.out.println("valeur de livraison après la livraison " + valAncienneLivraison);

		}
		return valAncienneLivraison;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			ILivraisonRemote instance = (ILivraisonRemote) new accesLivraison();
			Naming.rebind("Livraison", instance);

			System.out.println("Connexion réussie:acces livraison");
			int i = 0;

			while (i != -1) {

				System.out.println("Entrer la quantité à livrer");
				int qt = sc.nextInt();
				instance.livrer(qt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
