package org.scalsys.agile.service.impl;

import java.util.List;

import org.scalsys.agile.dao.IdeaVoteDAO;
import org.scalsys.agile.model.IdeaVote;
import org.scalsys.agile.service.IdeaVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdeaVoteServiceImpl implements IdeaVoteService{

	@Autowired
	private IdeaVoteDAO ideaVoteDAO;

	public IdeaVoteDAO getIdeaVoteDAO() {
		return ideaVoteDAO;
	}

	public void setIdeaVoteDAO(IdeaVoteDAO ideaVoteDAO) {
		this.ideaVoteDAO = ideaVoteDAO;
	}

	@Transactional
	public void createIdeaVote(IdeaVote ideaVote) {
		ideaVoteDAO.createIdeaVote(ideaVote);
	}

	@Transactional
	public List<IdeaVote> listIdeaVote() {
		
		return ideaVoteDAO.listIdeaVote();
	}

	@Transactional
	public IdeaVote getIdeaVote(Integer ideaVoteId) {
		return ideaVoteDAO.getIdeaVote(ideaVoteId);
	}

	@Transactional
	public Long getNextIdeaVoteId() {
		
		return ideaVoteDAO.getNextIdeaVoteId();
	}



	
}
