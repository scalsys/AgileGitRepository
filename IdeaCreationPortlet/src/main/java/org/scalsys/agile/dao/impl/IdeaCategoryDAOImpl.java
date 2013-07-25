package org.scalsys.agile.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scalsys.agile.dao.IdeaCategoryDAO;
import org.scalsys.agile.model.IdeaCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdeaCategoryDAOImpl implements IdeaCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public void createIdeaCategory(IdeaCategory ideaCategory) {
	
		System.out.println("createIdeaCategory Method called");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(ideaCategory);
		transaction.commit();
		session.close();
		
	}

	public List<IdeaCategory> listIdeaCategory() {
		System.out.println("listIdeaCategory Method called");
		Session session = sessionFactory.openSession();
		return session.createQuery("from IdeaCategory").list();
		
	}
}
