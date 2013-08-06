package org.scalsys.agile.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scalsys.agile.dao.IdeaSubCategoryDAO;
import org.scalsys.agile.model.IdeaSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdeaSubCategoryDAOImpl implements IdeaSubCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void createIdeaSubCategory(IdeaSubcategory ideaSubCategory) {
		System.out.println("createIdeaSubCategory Method called");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(ideaSubCategory);
		transaction.commit();
		session.close();
	}
	
	public List<IdeaSubcategory> listIdeaSubCategory() {
		
		System.out.println("listIdeaSubCategory Method called");
		Session session = sessionFactory.openSession();
		return session.createQuery("from IdeaSubcategory").list();
	}

	
	public IdeaSubcategory getIdeaSubCategory(Long subcategoryId) {
		Session session = sessionFactory.openSession();
		IdeaSubcategory ideaSubcategory = (IdeaSubcategory) session.get(
				IdeaSubcategory.class, subcategoryId);
		session.close();
		return ideaSubcategory;
	}
}
