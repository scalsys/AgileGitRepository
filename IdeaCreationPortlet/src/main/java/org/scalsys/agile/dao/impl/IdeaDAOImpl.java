package org.scalsys.agile.dao.impl;

import java.math.BigInteger;
import java.util.List;

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
		System.out.println("createIdea Method called");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(idea);
		transaction.commit();
		session.close();
	}

	
	public List<Idea> listIdea() {
		System.out.println("listIdea Method called");
		Session session = sessionFactory.openSession();
		return session.createQuery("from Idea").list();
	}


	
	public Idea getIdea(Integer ideaId) {
		
		Session session = sessionFactory.openSession();
		Idea idea = (Idea) session.get(
				Idea.class, ideaId);
		session.close();
		return idea;
	}
	
    public Long getNextIdeaId()
    {
    	Session session = sessionFactory.openSession();
    	Long ideaId = (Long) session.createQuery("select ideaId from Idea order by ideaId DESC LIMIT 1").list().get(0);
    	Long nextIdeaId = ideaId +1;
		session.close();
		return nextIdeaId;
    }
}
