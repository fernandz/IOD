package atm.oc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import atm.oc.model.JPAUtil;
import atm.oc.model.MyFirstClass;

public class RMIImpl implements IRMII {
	
	public RMIImpl(final int port) throws RemoteException {
		UnicastRemoteObject.exportObject(this, port);
	}   
	
	public void remover(MyFirstClass obj) throws RemoteException {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.remove(obj.getId());
		em.getTransaction().commit();

		em.close();
	}

	public void salvar(MyFirstClass obj) throws RemoteException {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();

		em.close();
	}

	public void atualizar(MyFirstClass obj) throws RemoteException {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();

		em.close();
	}

	public MyFirstClass consultar(String texto) throws RemoteException {
		EntityManager em = new JPAUtil().getEntityManager();
		List<MyFirstClass> lista = em.createQuery("FROM MyFirstClass", MyFirstClass.class).getResultList();

		for (MyFirstClass selected : lista) {
			if (selected.getTexto().equals(texto))
				return selected;
		}
		return null;
	}

}
