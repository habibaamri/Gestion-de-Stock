package client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import serveur.IProductionRemote;

public class AccesProduction_Clt {
	
	
	public static void main (String[] args){
		
		try{
			LocateRegistry.getRegistry(1099);
			IProductionRemote ObjetProduction=(IProductionRemote) Naming.lookup("ObjetProduction");
			System.out.println("Association réussie");
			ObjetProduction.stocker(30);
			
		}catch(Exception e){
		e.printStackTrace();}
	}
		
}