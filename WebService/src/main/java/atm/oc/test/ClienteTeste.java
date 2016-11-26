package atm.oc.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import atm.oc.model.MyFirstClass;
import atm.oc.rmi.IRMII;


public class ClienteTeste {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		System.setProperty("java.rmi.server.hostname","10.51.11.12:1099");
		IRMII testejpa = (IRMII)Naming.lookup("rmi://10.51.11.7:1099/rmi");
		
		System.out.println (testejpa);
		
		/*MyFirstClass obj = new MyFirstClass();
		obj.setNumero(123);
		obj.setTexto("Teste");
		
		testejpa.salvar(obj);*/
		
		
	}
}
