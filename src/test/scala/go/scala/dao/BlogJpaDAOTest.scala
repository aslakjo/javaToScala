package go.scala.dao

import org.junit.After
import javax.persistence.EntityTransaction
import javax.persistence.EntityManager
import javax.persistence.Persistence
import go.scala.dao.jpa.BlogJpaDAO
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import scala.collection.mutable.ListBuffer
import org.junit.Test
import org.junit.Before

import scala.collection.JavaConversions._

import go.scala.model._

class BlogJpaDAOTest extends CrudJpaDAOTest[java.lang.Long, Blog, BlogJpaDAO] {

  def createDao = new BlogJpaDAO
	
  def givenAModel(){
	model = new Blog
  }
	
  def whenUpdatingModel(){
	model.title = "updated"
  }
  
  def thenTheModelShouldBeUpdatedInTheDatabase(){
	assert(dao.find(model.id).title == "updated")
  }
  
  def id(blog:Blog) = {
	  blog.getId
  }
	
}