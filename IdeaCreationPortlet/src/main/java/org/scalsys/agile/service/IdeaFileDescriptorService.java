package org.scalsys.agile.service;

import org.scalsys.agile.model.IdeaDescriptorFile;

public interface IdeaFileDescriptorService {

	public void saveIdeaFile(IdeaDescriptorFile ideaDescriptorFile);
	public Long getNextIdeaId();
}
