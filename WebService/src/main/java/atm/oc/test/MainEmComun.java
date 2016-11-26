package atm.oc.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.xml.ws.Endpoint;

import atm.oc.rmi.RMIImpl;
import atm.oc.webservice.WebServiceImpl;

public class MainEmComun {
public static void main(String[] args) throws RemoteException, MalformedURLException {
	int port = 1099;
	LocateRegistry.createRegistry(port);//use any no. less than 55000
	RMIImpl rmi = new RMIImpl(port);
	Naming.rebind("rmi", rmi);
	System.err.println("Servidor RUNNING ");
	
	Endpoint.publish("http://0.0.0.0:54321/WebService", new WebServiceImpl());
}
}
