/**
 * @author jacoby - jking11@dmacc.edu
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

public class OwnerHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6-JPAJoins");
	
	public void insertOwner(Owner o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	public List<Owner> showAllOwners(){
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allShoppers = em.createQuery("SELECT o FROM Owner o").getResultList();
		return allShoppers;
	}
	public Owner findOwner(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select ow from Owner ow where ow.ownerName = :selectedName", Owner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Owner foundOwner;
		try{
			foundOwner = typedQuery.getSingleResult();
		}
		catch(NoResultException ex) {
			foundOwner = new Owner(nameToLookUp);
		}
		em.close();
		return foundOwner;
	}
}
