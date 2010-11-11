package go.scala.dao;

import java.util.List;

public interface CrudDAO<PK, M> {
	
	void persist(M model);
	
	M find(PK key);
	
	void remove(M model);
	
	M merge(M model);
	
	List<M> findAll(int offset, int maxResults);
	
}
