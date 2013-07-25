package org.scalsys.agile.dao;

import java.util.List;

import org.scalsys.agile.model.IdeaSubcategory;

public interface IdeaSubCategoryDAO {

	public void createIdeaSubCategory(IdeaSubcategory ideaSubCategory);
	public List<IdeaSubcategory> listIdeaSubCategory();
}
