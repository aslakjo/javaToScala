package go.scala.dao.jpa;

import go.scala.dao.EntryCrudDAO;
import go.scala.model.Entry;

class EntryJpaDAO extends CrudJpaDAO[Long, Entry] with EntryCrudDAO {
	
}

trait EntryJpaDAOPart{
	val entryCrudDAO = new EntryJpaDAO
}