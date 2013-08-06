package org.scalsys.agile.dao;

import java.util.List;

import org.scalsys.agile.model.Idea;

public interface IdeaDAO {

	public void createIdea(Idea idea);
	public List<Idea> listIdea();
	public Idea getIdea(Integer ideaId);
	  public Long getNextIdeaId();
}
