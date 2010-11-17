package go.scala.service

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

trait Loggable[M] {
	
	var log:Logger = _
	
	def logger(implicit m:Manifest[M]):Logger = {
		if(log == null){
			log = LoggerFactory.getLogger(m.erasure)
		}
		log
	}
}