package go.scala.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import go.scala.dao.CrudDAO;

public abstract class CrudJpaDAO<PK, M> implements CrudDAO<PK, M>{

	private final Class<M> enityClass;
	protected EntityManager em;
	
	protected CrudJpaDAO(Class<M> enityClass){
		this.enityClass = enityClass;
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	public M find(PK key) {
		return em.find(enityClass, key);
	}

	public List<M> findAll(int offset, int maxResults) {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<M> query = qb.createQuery(enityClass);
		List<M> result = em.createQuery(query).setFirstResult(offset).
			setMaxResults(maxResults).getResultList();
		return result;
	}

	public M merge(M model) {
		return em.merge(model);
	}

	public void remove(M model) {
		em.remove(model);
	}

	public void persist(M model) {
		em.persist(model);
	}

}
