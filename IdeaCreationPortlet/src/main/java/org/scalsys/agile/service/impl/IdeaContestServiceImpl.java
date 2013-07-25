package org.scalsys.agile.service.impl;

import java.util.List;

import org.scalsys.agile.dao.IdeaContestDAO;
import org.scalsys.agile.model.Contest;
import org.scalsys.agile.service.IdeaContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdeaContestServiceImpl implements IdeaContestService {

	@Autowired
	private IdeaContestDAO ideaContestDAO;

	public IdeaContestDAO getIdeaContestDAO() {
		return ideaContestDAO;
	}

	public void setIdeaContestDAO(IdeaContestDAO ideaContestDAO) {
		this.ideaContestDAO = ideaContestDAO;
	}

	@Transactional
	public void createIdeaContest(Contest contest) {
		ideaContestDAO.createIdeaContest(contest);
		
	}

	@Transactional
	public List<Contest> listContest() {
		
		return ideaContestDAO.listContest();
	}
}
