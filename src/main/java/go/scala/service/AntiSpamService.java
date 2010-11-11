package go.scala.service;

import go.scala.model.Comment;

public class AntiSpamService {
	
	public boolean isSpam(Comment comment){
		return comment.getText().matches(".*enlarge\\s+your\\s+williesjeep.*");
	}
}
