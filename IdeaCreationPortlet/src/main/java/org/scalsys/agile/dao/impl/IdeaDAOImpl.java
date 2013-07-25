package org.scalsys.agile.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scalsys.agile.dao.IdeaDAO;
import org.scalsys.agile.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdeaDAOImpl implements IdeaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void createIdea(Idea idea) {
		System.out.println("createIdea() called");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(idea);
		transaction.commit();
		session.close();
	}
}
