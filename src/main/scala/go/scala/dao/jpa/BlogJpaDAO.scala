package go.scala.dao.jpa

import go.scala.dao.BlogCrudDAO
import go.scala.model.Blog

import java.lang.{Long => JLong}

class BlogJpaDAO extends CrudJpaDAO[Long, Blog] with BlogCrudDAO {
	
}