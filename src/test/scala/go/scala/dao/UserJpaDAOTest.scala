package go.scala.dao

import org.junit.After
import javax.persistence.EntityTransaction
import javax.persistence.EntityManager
import javax.persistence.Persistence
import go.scala.dao.jpa.UserJpaDAO
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import scala.collection.mutable.ListBuffer
import org.junit.Test
import org.junit.Before

import scala.collection.JavaConversions._

import go.scala.model._

class UserJpaDAOTest extends CrudJpaDAOTest[Long, User, UserJpaDAO] {

  def createDao = new UserJpaDAO
	
  def givenAModel(){
	model = new User
  }
	
  def whenUpdatingModel(){
	model.name = "updated"
  }
  
  def thenTheModelShouldBeUpdatedInTheDatabase(){
	assert(dao.find(model.getId).name == "updated")
  }
  
  def id(user:User) = {
	  user.getId
  }
	
}