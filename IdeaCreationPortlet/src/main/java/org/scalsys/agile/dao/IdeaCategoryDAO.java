package org.scalsys.agile.dao;

import java.util.List;

import org.scalsys.agile.model.IdeaCategory;

public interface IdeaCategoryDAO {

	public void createIdeaCategory(IdeaCategory ideaCategory);
	public List<IdeaCategory> listIdeaCategory();
	public IdeaCategory getIdeaCategory(Long categoryId); 
}
