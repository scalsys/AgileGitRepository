package org.scalsys.agile.service;

import java.util.List;

import org.scalsys.agile.model.Contest;

public interface IdeaContestService {

	public void createIdeaContest(Contest contest);
	public List<Contest> listContest();
	public Contest getIdeaContest(Long ideaContestId); 
	
}
