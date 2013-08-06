package org.scalsys.agile.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scalsys.agile.dao.IdeaFileDescriptorDAO;
import org.scalsys.agile.model.IdeaDescriptorFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdeaFileDescriptorDAOImpl implements IdeaFileDescriptorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Long getNextIdeaId() {
		Session session = sessionFactory.openSession();
    	Long ideaFileId = (Long) session.createQuery("select fileId from IdeaDescriptorFile order by fileId DESC LIMIT 1").list().get(0);
    	Long nextideaFileId = ideaFileId +1;
		session.close();
		return nextideaFileId;
		
	}
	public void saveIdeaFile(IdeaDescriptorFile ideaDescriptorFile) {
		System.out.println("saveIdeaFile Method called");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(ideaDescriptorFile);
		transaction.commit();
		session.close();
		
	}


	
}
