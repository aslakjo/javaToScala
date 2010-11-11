package go.scala.dao.jpa;

import go.scala.dao.UserCrudDAO;
import go.scala.model.User;

public class UserJpaDAO extends CrudJpaDAO<Long, User> implements UserCrudDAO {

	public UserJpaDAO() {
		super(User.class);
	}
	
}