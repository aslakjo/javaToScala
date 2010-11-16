package go.scala.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import go.scala.dao.CrudDAO;

abstract class CrudJpaDAO[PK, M](implicit m: Manifest[M]) extends CrudDAO[PK, M]{

	var em:EntityManager = _
	
	def find(key:PK):M = {
		em.find(m.erasure, key).asInstanceOf[M]
	}

	def findAll(offset:Int, maxResults:Int):List[M] = {
		val qb = em.getCriteriaBuilder()
		val query = qb.createQuery(m.erasure)
		em.createQuery(query).setFirstResult(offset).
			setMaxResults(maxResults).getResultList().asInstanceOf[List[M]]
	}

	def merge(model:M) = {
		em.merge(model)
	}

	def remove(model:M) {
		em.remove(model)
	}

	def persist(model:M) {
		em.persist(model)
	}

}
