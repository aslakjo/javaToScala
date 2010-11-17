package go.scala.service

import go.scala.model.Comment

class AntiSpamService {
	
	def isSpam(comment:Comment) = {
		comment.getText().matches(".*enlarge\\s+your\\s+williesjeep.*")
	}
}

trait AntiSpamServicePart {
	val antiSpamService = new AntiSpamService
}
