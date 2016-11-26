package atm.oc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramaTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 EntityManager em = new JPAUtil().getEntityManager();
		
	List<MyFirstClass> lista = em.createQuery("FROM MyFirstClass",MyFirstClass.class).getResultList();
	
	for (MyFirstClass objeto : lista){
		System.out.println("Objeto no banco: " + objeto.getNumero() + "," + objeto.getTexto());
		
	}
	MyFirstClass objeto = new MyFirstClass();
	objeto.setNumero(9555);
	objeto.setTexto("Texto caio");
	
	em.getTransaction().begin();
	em.persist(objeto);
	em.getTransaction().commit();
	
	em.close();
	}

}
