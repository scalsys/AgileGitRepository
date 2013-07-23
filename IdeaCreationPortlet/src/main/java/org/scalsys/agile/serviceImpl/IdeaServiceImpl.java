package org.scalsys.agile.serviceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scalsys.agile.model.Idea;
import org.scalsys.agile.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;

public class IdeaServiceImpl implements IdeaService {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Boolean createIdea(Idea idea) {
		System.out.println("createIdea() called");
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(idea);
		transaction.commit();
		session.close();
		// TODO Auto-generated method stub
		return null;
	}

}
