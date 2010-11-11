package go.scala.dao.jpa;

import go.scala.dao.EntryCrudDAO;
import go.scala.model.Entry;

public class EntryJpaDAO extends CrudJpaDAO<Long, Entry> implements EntryCrudDAO {

	public EntryJpaDAO() {
		super(Entry.class);
	}
	
}