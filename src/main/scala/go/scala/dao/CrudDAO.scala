package go.scala.dao;

import java.util.List;

trait CrudDAO[PK, M] {
	
	def persist(model:M)
	
	def find(key:PK):M
	
	def remove(model:M)
	
	def merge(model:M):M
	
	def findAll(offset:Int, maxResults:Int):List[M]
	
}
