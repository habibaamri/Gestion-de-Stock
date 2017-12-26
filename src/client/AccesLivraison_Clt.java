package client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import serveur.ILivraisonRemote;
import serveur.IProductionRemote;

public class AccesLivraison_Clt {

	public static void main(String[] args) {
		
		try{
			LocateRegistry.getRegistry(1098);
			ILivraisonRemote ObjetLivraison=(ILivraisonRemote) Naming.lookup("ObjLivraison");
			System.out.println("Association réussie");
			ObjetLivraison.livrer(50);
			
		}catch(Exception e){
		e.printStackTrace();}
	}

}
