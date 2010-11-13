package go.scala.model

import javax.persistence.{GeneratedValue, Id}
import reflect.BeanProperty

trait IdPK {
	@Id
	@GeneratedValue
	@BeanProperty
	var id:Long = _
}