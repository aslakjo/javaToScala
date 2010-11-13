package go.scala.model

import java.util.List;

import javax.persistence.{Entity, ManyToOne, OneToMany}
import reflect.BeanInfo

@Entity
@BeanInfo
class Blog extends IdPK {
	
	var title:String = _
	var decription:String = _
	
	@ManyToOne
	var user:User = _
	
	@OneToMany
	var entries:List[Entry] = _
	
	override def hashCode = {
		val prime = 31;
		prime + (id match {
			case l:Long => l.hashCode
			case _ => 0
		})
	}
	
	override def equals(other:Any) = {
		other match{
			case b:Blog if(id == b.id) => true
			case _ => false
		}
	}

	override def toString = {
		"Blog [decription=" + decription + ", entries=" + entries + ", id=" + id + 
			", title=" + title + ", user=" + user + "]"
	}
	
	
}