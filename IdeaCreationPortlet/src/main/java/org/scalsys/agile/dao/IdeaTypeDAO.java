package org.scalsys.agile.dao;

import java.util.List;

import org.scalsys.agile.model.IdeaType;

public interface IdeaTypeDAO {
	
	public void createIdeaType(IdeaType ideaType);
	public List<IdeaType> listIdeaType();
	public IdeaType getIdeaType(Long ideaTypeId);

}
