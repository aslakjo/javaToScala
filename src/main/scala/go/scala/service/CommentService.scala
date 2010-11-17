package go.scala.service;

import go.scala.dao.EntryCrudDAO;
import go.scala.model.Comment;
import go.scala.model.Entry;

class CommentService extends Loggable[CommentService]{
	
	var antiSpamService:AntiSpamService = _
	var entryCrudDAO:EntryCrudDAO = _

	def setAntiSpamService(antiSpamService:AntiSpamService){
		this.antiSpamService = antiSpamService;
	}
	
	def setEntryCrudDAO(entryCrudDAO:EntryCrudDAO) {
		this.entryCrudDAO = entryCrudDAO;
	}
	
	def addComment(entry:Entry, comment:Comment){
		logger.debug("addComment");
		if(!antiSpamService.isSpam(comment)){
			entry.addComment(comment);
			entryCrudDAO.merge(entry);
		}else{
			logger.info("detected SPAM in: " + comment);
		}
	}
	
}
