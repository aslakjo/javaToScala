package go.scala.dao

import go.scala.dao.jpa.CrudJpaDAO
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

trait CrudJpaDAOTest[PK, M, DAO <: CrudJpaDAO[PK,M]] extends JUnitSuite with ShouldMatchersForJUnit {

  var model:M = _
  var dao:DAO = _
  var em:EntityManager = _
  var transcation:EntityTransaction = _
  var models:List[M] = _
  
  @Before
  def startUpDAO(){
	  dao = createDao
	  val emf = Persistence.createEntityManagerFactory("goscala");
      em = emf.createEntityManager();
      transcation = em.getTransaction()
      transcation.begin
	  dao.setEntityManager(em)
  }
  
  def createDao():DAO
  
  @After
  def tearDownDAO(){
	  transcation.rollback
  }
	
  @Test def shouldSave() { 
	  givenAModel
	  whenSavingTheModel
	  thenTheModelShouldBeInTheDatabase
  }
  
  @Test def shouldRemove(){
	  givenAPersistedModel
	  whenRemoingModel
	  thenTheModelShouldBeRemovedFromTheDatabse
  }
  
  @Test def shouldUpdate(){
	  givenAPersistedModel
	  whenUpdatingModel
	  thenTheModelShouldBeUpdatedInTheDatabase
  }
  
  @Test def shouldFindAll(){
	  givenThreePersistedModels
	  whenSearchingForModels
	  thenOneShouldFindModels
  }
  
  def givenThreePersistedModels(){
	  (0 until 3).foreach(_ =>{givenAPersistedModel})
  }
  
  def whenSearchingForModels(){
	  models = dao.findAll(0, 10).toList
  }
  
  def thenOneShouldFindModels(){
	  assert(models.size == 3)
  }
  
  def givenAModel()
  
  def givenAPersistedModel(){
	  givenAModel
	  whenSavingTheModel
  }
  def whenSavingTheModel(){
	  dao.persist(model)
  }
  def whenUpdatingModel()
  
  def thenTheModelShouldBeUpdatedInTheDatabase()
  
  def thenTheModelShouldBeInTheDatabase(){
	  assert(id(model) != null)
  }
  def id(model:M):PK
  
  def whenRemoingModel(){
	  dao.remove(model)
  }
  def thenTheModelShouldBeRemovedFromTheDatabse(){
	  assert(dao.find(id(model)) == null)
  }
}