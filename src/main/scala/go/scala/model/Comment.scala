package go.scala.model

import javax.persistence.{Entity, ManyToOne}
import reflect.BeanProperty

@Entity
class Comment extends IdPK[Comment]{
	
	@BeanProperty var title:String = _
	@BeanProperty var text:String = _

	@ManyToOne
	@BeanProperty var user:User = _

	override def toString() = "Comment [id=" + id + ", text=" + text + ", title=" + title + ", user=" + user + "]"
}
