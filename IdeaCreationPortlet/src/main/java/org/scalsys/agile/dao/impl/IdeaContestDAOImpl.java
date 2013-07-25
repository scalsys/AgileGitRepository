package org.scalsys.agile.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scalsys.agile.dao.IdeaContestDAO;
import org.scalsys.agile.model.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdeaContestDAOImpl implements IdeaContestDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void createIdeaContest(Contest contest) {
	
		System.out.println("createIdeaContest Method called");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(contest);
		transaction.commit();
		session.close();
		
	}

	
	public List<Contest> listContest() {
		System.out.println("listIdeaContest Method called");
		Session session = sessionFactory.openSession();
		return session.createQuery("from Contest").list();
	}
}
