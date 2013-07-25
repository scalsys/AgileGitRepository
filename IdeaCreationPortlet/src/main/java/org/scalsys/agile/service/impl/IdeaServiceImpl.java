package org.scalsys.agile.service.impl;

import org.scalsys.agile.dao.IdeaDAO;
import org.scalsys.agile.model.Idea;
import org.scalsys.agile.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdeaServiceImpl implements IdeaService {

	@Autowired
	private IdeaDAO ideaDAO;

	public IdeaDAO getIdeaDAO() {
		return ideaDAO;
	}

	public void setIdeaDAO(IdeaDAO ideaDAO) {
		this.ideaDAO = ideaDAO;
	}

	@Transactional
	public void createIdea(Idea idea) {
		ideaDAO.createIdea(idea);
	}
}
