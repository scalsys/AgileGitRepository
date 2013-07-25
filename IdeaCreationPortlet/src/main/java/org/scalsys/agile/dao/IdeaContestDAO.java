package org.scalsys.agile.dao;

import java.util.List;

import org.scalsys.agile.model.Contest;

public interface IdeaContestDAO {

	public void createIdeaContest(Contest contest);
	public List<Contest> listContest();
}
