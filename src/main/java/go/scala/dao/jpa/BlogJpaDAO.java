package go.scala.dao.jpa;

import go.scala.dao.BlogCrudDAO;
import go.scala.model.Blog;

public class BlogJpaDAO extends CrudJpaDAO<Long, Blog> implements BlogCrudDAO {

	public BlogJpaDAO() {
		super(Blog.class);
	}
	
}