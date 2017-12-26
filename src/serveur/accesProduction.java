package serveur;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class accesProduction extends UnicastRemoteObject implements IProductionRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int valAncienneStock = 0;

	public accesProduction accesProduction;

	protected accesProduction() throws RemoteException {
		super();

	}

	public boolean preStocker(int valAncienneStock, int nouvelleValStock, int valLivraison) {

		if ((valAncienneStock + nouvelleValStock) - valLivraison <= NombreMaxStock) {
			return true;
		} else if ((valAncienneStock + nouvelleValStock) - valLivraison == NombreMaxStock)
			return false;
		else
			return false;
	}

	@Override
	public int stocker(int quantité) {

		System.out.println("La valeur de s avant la production\t" + valAncienneStock + "\n");

		try {
			ILivraisonRemote livraisonRem = (ILivraisonRemote) Naming.lookup("Livraison");

			if (preStocker(valAncienneStock, quantité, livraisonRem.getValLivraison()) == true) {

				valAncienneStock = valAncienneStock + quantité;

				System.out.println("La quantité de stock apres la production\t" + valAncienneStock + "\n");
				return valAncienneStock;
			} else {
				System.out.println("Le stock est plein");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return valAncienneStock;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			IProductionRemote instance = (IProductionRemote) new accesProduction();
			Naming.rebind("Production", instance);

			System.out.println("Association réussie:Acces Production");
			int i = 0;

			while (i != -1) {
				System.out.println("Entrer une quantité");
				int quantité = sc.nextInt();

				instance.stocker(quantité);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

	@Override
	public int getValstock() throws RemoteException {
		return valAncienneStock;
	}

}
