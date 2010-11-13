package go.scala.model

import javax.persistence.{GeneratedValue, Id}
import reflect.BeanProperty

trait IdPK[T <: IdPK[T]] {
	@Id
	@GeneratedValue
	@BeanProperty
	var id:Long = _
	
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
			case e:T if(id == e.id) => true
			case _ => false
		}
	}
}