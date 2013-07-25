package org.scalsys.agile.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scalsys.agile.dao.IdeaTypeDAO;
import org.scalsys.agile.model.IdeaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdeaTypeDAOImpl implements IdeaTypeDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void createIdeaType(IdeaType ideaType) {
		
		System.out.println("createIdeaType Method called");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(ideaType);
		transaction.commit();
		session.close();
	}

	
	public List<IdeaType> listIdeaType() {
		System.out.println("listIdeaType Method called");
		Session session = sessionFactory.openSession();
		return session.createQuery("from IdeaType").list();
	}

}
