package org.scalsys.agile.service.impl;

import org.scalsys.agile.dao.IdeaFileDescriptorDAO;
import org.scalsys.agile.model.IdeaDescriptorFile;
import org.scalsys.agile.service.IdeaFileDescriptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdeaFileDescriptorServiceImpl implements IdeaFileDescriptorService {

	@Autowired
	private IdeaFileDescriptorDAO ideaFileDescriptorDAO;
	
	public IdeaFileDescriptorDAO getIdeaFileDescriptorDAO() {
		return ideaFileDescriptorDAO;
	}

	public void setIdeaFileDescriptorDAO(IdeaFileDescriptorDAO ideaFileDescriptorDAO) {
		this.ideaFileDescriptorDAO = ideaFileDescriptorDAO;
	}


	@Transactional
	public void saveIdeaFile(IdeaDescriptorFile ideaDescriptorFile) {
		ideaFileDescriptorDAO.saveIdeaFile(ideaDescriptorFile);
		
	}

	
	@Transactional
	public Long getNextIdeaId() {
		
		return ideaFileDescriptorDAO.getNextIdeaId();
	}

	

	
}
