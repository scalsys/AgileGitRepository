package org.scalsys.agile.service.impl;

import java.util.List;

import org.scalsys.agile.dao.IdeaCategoryDAO;
import org.scalsys.agile.model.IdeaCategory;
import org.scalsys.agile.service.IdeaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdeaCategoryServiceImpl implements IdeaCategoryService {

	@Autowired
	private IdeaCategoryDAO ideaCategoryDAO;

	public IdeaCategoryDAO getIdeaCategoryDAO() {
		return ideaCategoryDAO;
	}

	public void setIdeaCategoryDAO(IdeaCategoryDAO ideaCategoryDAO) {
		this.ideaCategoryDAO = ideaCategoryDAO;
	}

	@Transactional
	public void createIdeaCategory(IdeaCategory ideaCategory) {
		ideaCategoryDAO.createIdeaCategory(ideaCategory);	
	}

	@Transactional
	public List<IdeaCategory> listCategory() {
		
		return ideaCategoryDAO.listIdeaCategory();
	}
}
