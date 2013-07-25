package org.scalsys.agile.service.impl;

import java.util.List;

import org.scalsys.agile.dao.IdeaTypeDAO;
import org.scalsys.agile.model.IdeaType;
import org.scalsys.agile.service.IdeaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdeaTypeServiceImpl implements IdeaTypeService{
 
	@Autowired
	IdeaTypeDAO ideaTypeDAO;

	public IdeaTypeDAO getIdeaTypeDAO() {
		return ideaTypeDAO;
	}

	public void setIdeaTypeDAO(IdeaTypeDAO ideaTypeDAO) {
		this.ideaTypeDAO = ideaTypeDAO;
	}

	@Transactional
	public void createIdeaType(IdeaType ideaType) {
		ideaTypeDAO.createIdeaType(ideaType);
	}

	@Transactional
	public List<IdeaType> listIdeaType() {
	
		return ideaTypeDAO.listIdeaType();
	}
}