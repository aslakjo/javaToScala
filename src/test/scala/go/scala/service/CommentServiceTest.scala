package go.scala.service

import org.junit.After
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import scala.collection.mutable.ListBuffer
import org.junit.Test
import org.junit.Before

import scala.collection.JavaConversions._

import go.scala.model._

import go.scala.dao.jpa.{EntryJpaDAO}
import go.scala.dao.EntryCrudDAO

class CommentServiceTest extends JUnitSuite with ShouldMatchersForJUnit{

  var commentService:CommentService = _
  var comment:Comment = _
  var entry:Entry = _
  var merged:Boolean = false
  
  @Before
  def setup{
	trait EntryJpaDAOPart{ 
		val entryCrudDAO = new EntryJpaDAO{
			override def merge(entry:Entry):Entry = {
				merged = true
				entry
			}
		}
	}
	commentService = new CommentService with EntryJpaDAOPart with AntiSpamServicePart
	comment = new Comment
	entry = new Entry
  }
  
  @Test def shouldNotStoreAMaliciousComment{
	  givenMaliciousComment
	  whenAddingTheComment
	  thenTheCommentShouldNotBeAddedToTheEntry
  }
  
  @Test def shouldStoreGoodComment{
	  givenGoodComment
	  whenAddingTheComment
	  thenTheCommentShouldBeAddedToTheEntry
	  andStored
  }

  def givenGoodComment{
	  comment.setTitle("Good")
	  comment.setText("You got a great williesjeep. Run fast!")
  }
  
  def givenMaliciousComment{
	  comment.setTitle("Bad")
	  comment.setText("You need to enlarge your williesjeep. Add a rear spoiler!")
  }
  
  def whenAddingTheComment{
	  commentService.addComment(entry, comment)
  }
  
  def thenTheCommentShouldNotBeAddedToTheEntry{
	  assert(!entry.comments.contains(comment))
  }
  
  def thenTheCommentShouldBeAddedToTheEntry{
	  assert(entry.comments.contains(comment))
  }
  
  def andStored{
	  assert(merged)
  }
	
}