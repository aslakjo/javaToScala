package go.scala.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import go.scala.dao.EntryCrudDAO;
import go.scala.model.Comment;
import go.scala.model.Entry;

public class CommentService {
	
	static final Logger logger = LoggerFactory.getLogger(CommentService.class);
	
	private AntiSpamService antiSpamService;
	private EntryCrudDAO entryCrudDAO;

	public void setAntiSpamService(AntiSpamService antiSpamService){
		this.antiSpamService = antiSpamService;
	}
	
	public void setEntryCrudDAO(EntryCrudDAO entryCrudDAO) {
		this.entryCrudDAO = entryCrudDAO;
	}
	
	public void addComment(Entry entry, Comment comment){
		logger.debug("addComment");
		if(!antiSpamService.isSpam(comment)){
			entry.addComment(comment);
			entryCrudDAO.merge(entry);
		}else{
			logger.info("detected SPAM in: " + comment);
		}
	}
	
}
