package go.scala.model

import java.util.{ArrayList, Date, List}

import javax.persistence.{CascadeType, Entity, GeneratedValue, Id, OneToMany, Temporal, TemporalType}

import reflect.BeanInfo

@Entity
@BeanInfo
class Entry {
	
	@Id
	@GeneratedValue
	var id:Long = _
	var title:String = _
	var text:String = _
	var published:Boolean = _
	
	@Temporal(TemporalType.TIMESTAMP)
	var created:Date = _
	
	@OneToMany(cascade = Array(CascadeType.ALL))
	var comments:List[Comment] = new ArrayList

	def addComment(comment:Comment) {
		comments.add(comment)
	}
	
	override def hashCode = {
		val prime = 31;
		var result = 1;
		prime * result + (id match{
			case l:Long => l.hashCode
			case _ => 0
		})
	}
	
	override def equals(other:Any) = {
		other match {
			case e:Entry if(id == e.id) => true
			case _ => false
		}
	}

	override def toString() = {
		"Entry [comments=" + comments + ", created=" + created + ", id=" + id + 
			", published=" + published + ", text=" + text + ", title=" + title + "]"
	}

}
