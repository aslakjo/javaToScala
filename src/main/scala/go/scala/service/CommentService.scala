package go.scala.service;

import go.scala.dao.EntryCrudDAO;
import go.scala.model.Comment;
import go.scala.model.Entry;

abstract class CommentService extends Loggable[CommentService]{
	
	val antiSpamService:AntiSpamService
	val entryCrudDAO:EntryCrudDAO

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
