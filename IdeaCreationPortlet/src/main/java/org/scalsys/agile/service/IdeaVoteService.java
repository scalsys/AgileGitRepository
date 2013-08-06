package org.scalsys.agile.service;

import java.util.List;

import org.scalsys.agile.model.IdeaVote;

public interface IdeaVoteService {

	public void createIdeaVote(IdeaVote ideaVote);
	public List<IdeaVote> listIdeaVote();
	public IdeaVote getIdeaVote(Integer ideaVoteId);
	public Long getNextIdeaVoteId();
}
