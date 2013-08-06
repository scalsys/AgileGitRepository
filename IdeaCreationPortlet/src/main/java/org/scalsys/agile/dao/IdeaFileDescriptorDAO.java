package org.scalsys.agile.dao;

import org.scalsys.agile.model.IdeaDescriptorFile;

public interface IdeaFileDescriptorDAO {

	public Long getNextIdeaId();

	public void saveIdeaFile(IdeaDescriptorFile ideaDescriptorFile);

	
}
