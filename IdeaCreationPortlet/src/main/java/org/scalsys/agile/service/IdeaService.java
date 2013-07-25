package org.scalsys.agile.service;

import java.util.List;

import org.scalsys.agile.model.Idea;

public interface IdeaService {

	public void createIdea(Idea idea);
	public List<Idea> listIdea();
}
