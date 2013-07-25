package org.scalsys.agile.service;

import java.util.List;

import org.scalsys.agile.model.IdeaCategory;

public interface IdeaCategoryService {

	public void createIdeaCategory(IdeaCategory ideaCategory);
	public List<IdeaCategory> listCategory();
}
