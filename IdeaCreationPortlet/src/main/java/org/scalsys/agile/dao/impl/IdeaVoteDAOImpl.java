package org.scalsys.agile.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scalsys.agile.dao.IdeaVoteDAO;
import org.scalsys.agile.model.IdeaVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdeaVoteDAOImpl implements IdeaVoteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void createIdeaVote(IdeaVote ideaVote) {
          
		System.out.println("createIdeaVote Method called");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(ideaVote);
		transaction.commit();
		session.close();
		
	}

	public List<IdeaVote> listIdeaVote() {
		System.out.println("listIdeaVote Method called");
		Session session = sessionFactory.openSession();
		return session.createQuery("from IdeaVote").list();
	}


	public IdeaVote getIdeaVote(Integer ideaVoteId) {
		Session session = sessionFactory.openSession();
		IdeaVote ideaVote= (IdeaVote) session.get(
				IdeaVote.class, ideaVoteId);
		session.close();
		return ideaVote;
	}

	public Long getNextIdeaVoteId() {
		Session session = sessionFactory.openSession();
    	Long ideaVoteId = (Long) session.createQuery("select voteId from IdeaVote order by voteId DESC LIMIT 1").list().get(0);
        Long nextIdeaVoteId = ideaVoteId + 1;
		session.close();
		return nextIdeaVoteId;
	}
}
