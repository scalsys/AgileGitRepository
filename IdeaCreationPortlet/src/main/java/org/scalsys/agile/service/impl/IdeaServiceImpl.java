package org.scalsys.agile.service.impl;

import java.util.List;

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

	@Transactional
	public List<Idea> listIdea() {
	
		return ideaDAO.listIdea();
	}

	@Transactional
	public Idea getIdea(Integer ideaId) {
		
		return ideaDAO.getIdea(ideaId);
	}

	@Transactional
	public Long getNextIdeaId() {
		
		return ideaDAO.getNextIdeaId();
	}
}
