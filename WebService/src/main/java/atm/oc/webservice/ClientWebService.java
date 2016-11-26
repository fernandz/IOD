package atm.oc.webservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;



public class ClientWebService {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://127.0.0.1:54321/WebService?wsdl");
		 
        QName qname = new QName("http://webservice.oc.atm/", "WebServiceImplService");
 
        Service service = Service.create(url, qname);
 
        IWebService iwb = service.getPort(IWebService.class);
        
        System.out.println(iwb.consultarUsuario(1L));
	}
}
