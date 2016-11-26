package atm.oc.webservice;

import javax.jws.WebService;
import javax.persistence.EntityManager;

import atm.oc.model.JPAUtil;
import atm.oc.model.MyFirstClass;

@WebService(endpointInterface = "atm.oc.webservice.IWebService")
public class WebServiceImpl implements IWebService	{

	
	public String consultarUsuario(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		Object singleResult = em.createQuery("Select i.texto from MyFirstClass i where i.id = :id ").setParameter("id", id).getSingleResult();
		em.close();
		
		return  (String) singleResult;
		
	}

}
