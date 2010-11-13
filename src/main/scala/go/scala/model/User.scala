package go.scala.model

import java.util.List

import javax.persistence.{Entity, Table}
import reflect.BeanInfo

@Entity
@Table(name="USER_TABLE")
@BeanInfo
class User extends IdPK{
	
	var name:String = _
	var email:String = _
	var password:String = _
	var blogs:List[Blog] = _

	override def hashCode() = {
		val prime = 31
		prime + (id match{
			case l:Long => l.hashCode
			case _ => 0
		})
	}
	override def equals(other:Any) = {
		other match {
			case u:User if(u.id == id) => true
			case _ => false
		} 
	}
	
	override def toString() = {
		 "User [blogs=" + blogs + ", email=" + email + ", id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	
}
