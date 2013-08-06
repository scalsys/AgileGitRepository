package org.scalsys.agile.service;

import java.util.List;

import org.scalsys.agile.model.IdeaType;

public interface IdeaTypeService {

	public void createIdeaType(IdeaType ideaType);
	public List<IdeaType> listIdeaType();
	public IdeaType getIdeaType(Long ideaTypeId); 
}
