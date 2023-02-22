/**
 * @author jacoby - jking11@dmacc.edu
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.OwnerDetails;

public class OwnerDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6-JPAJoins");
	
	public void insertNewOwnerDetails(OwnerDetails o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	public List<OwnerDetails> getOwners(){
		EntityManager em = emfactory.createEntityManager();
		List<OwnerDetails> allDetails = em.createQuery("SELECT o FROM OwnerDetails o").getResultList();
		return allDetails;
	}
	public void deleteOwner(OwnerDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<OwnerDetails> typedQuery = em.createQuery("select detail from OwnerDetails detail where detail.id = :selectedId", OwnerDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		OwnerDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public OwnerDetails searchForOwnerDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		OwnerDetails found = em.find(OwnerDetails.class, tempId);
		em.close();
		return found;
	}
	public void updateOwner(OwnerDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
