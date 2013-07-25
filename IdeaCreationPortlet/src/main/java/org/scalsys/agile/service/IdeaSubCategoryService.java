package org.scalsys.agile.service;

import java.util.List;

import org.scalsys.agile.model.IdeaSubcategory;

public interface IdeaSubCategoryService {

	public void createIdeaSubCategory(IdeaSubcategory ideaSubcategory);
	public List<IdeaSubcategory> listSubCategory();
}
