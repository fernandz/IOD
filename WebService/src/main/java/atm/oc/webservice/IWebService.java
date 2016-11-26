package atm.oc.webservice;

import atm.oc.model.MyFirstClass;
import javax.jws.WebService;

@WebService
public interface IWebService {

	public String consultarUsuario(Long id);
	 
}
