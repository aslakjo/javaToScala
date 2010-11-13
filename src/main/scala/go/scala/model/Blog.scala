package go.scala.model

import java.util.List;

import javax.persistence.{Entity, ManyToOne, OneToMany}
import reflect.BeanInfo

@Entity
@BeanInfo
class Blog extends IdPK[Blog] {
	
	var title:String = _
	var decription:String = _
	
	@ManyToOne
	var user:User = _
	
	@OneToMany
	var entries:List[Entry] = _
	
	override def toString = {
		"Blog [decription=" + decription + ", entries=" + entries + ", id=" + id + 
			", title=" + title + ", user=" + user + "]"
	}
	
	
}