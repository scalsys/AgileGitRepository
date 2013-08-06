package org.scalsys.agile.service.impl;

import java.util.List;

import org.scalsys.agile.dao.IdeaSubCategoryDAO;
import org.scalsys.agile.model.IdeaSubcategory;
import org.scalsys.agile.service.IdeaSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdeaSubCategoryServiceImpl implements IdeaSubCategoryService {

	@Autowired
	private IdeaSubCategoryDAO ideaSubCategoryDAO;

	

	public IdeaSubCategoryDAO getIdeaSubCategoryDAO() {
		return ideaSubCategoryDAO;
	}

	public void setIdeaSubCategoryDAO(IdeaSubCategoryDAO ideaSubCategoryDAO) {
		this.ideaSubCategoryDAO = ideaSubCategoryDAO;
	}


	@Transactional
	public void createIdeaSubCategory(IdeaSubcategory ideaSubcategory) {	
		ideaSubCategoryDAO.createIdeaSubCategory(ideaSubcategory);
	}

	@Transactional
	public List<IdeaSubcategory> listSubCategory() {
	  return ideaSubCategoryDAO.listIdeaSubCategory();	
	}

	@Transactional
	public IdeaSubcategory getIdeaSubCategory(Long subcategoryId) {
		 return ideaSubCategoryDAO.getIdeaSubCategory(subcategoryId);	
	}
}
