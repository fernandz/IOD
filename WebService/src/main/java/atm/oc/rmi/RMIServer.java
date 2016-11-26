package atm.oc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		int port = 1099;
		LocateRegistry.createRegistry(port);//use any no. less than 55000
		RMIImpl rmi = new RMIImpl(port);
		Naming.rebind("rmi", rmi);
		System.err.println("Servidor RUNNING ");
		

	}
}
