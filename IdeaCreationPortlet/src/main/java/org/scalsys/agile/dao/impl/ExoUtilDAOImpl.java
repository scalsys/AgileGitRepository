package org.scalsys.agile.dao.impl;

import java.math.BigInteger;

import org.exoplatform.portal.webui.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.scalsys.agile.dao.ExoUtilDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExoUtilDAOImpl implements ExoUtilDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public Long getRemoteUser()
	{
		String userName = Util.getPortalRequestContext().getRemoteUser();
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select ID from jbid_io where NAME='"+userName+"'");
		BigInteger bigUserId = (BigInteger) query.list().get(0);
		session.close();
		Long userId = bigUserId.longValue();
	    return userId;
		
	}

}
