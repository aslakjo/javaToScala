package go.scala.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import java.lang.Long
import reflect.BeanProperty

@Entity
class Comment {
	
	@Id
	@GeneratedValue
	@BeanProperty var id:Long = _
	@BeanProperty var title:String = _
	@BeanProperty var text:String = _

	@ManyToOne
	@BeanProperty var user:User = _

	override def hashCode() = {
		val prime = 31;
		prime + (id match {
			case l:Long => l.hashCode
			case _ => 0
		})
	}

	override def equals(other:Any) = {
		other match {
			case c:Comment if(c.id == id) => true
			case _ => false
		}
	}

	override def toString() = "Comment [id=" + id + ", text=" + text + ", title=" + title + ", user=" + user + "]"
}
