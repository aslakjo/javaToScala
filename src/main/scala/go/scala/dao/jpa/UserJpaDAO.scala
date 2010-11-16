package go.scala.dao.jpa;

import go.scala.dao.UserCrudDAO;
import go.scala.model.User;

class UserJpaDAO extends CrudJpaDAO[Long, User] with UserCrudDAO {

}