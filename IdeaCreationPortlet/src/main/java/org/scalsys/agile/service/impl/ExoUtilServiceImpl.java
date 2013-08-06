package org.scalsys.agile.service.impl;

import org.scalsys.agile.dao.ExoUtilDAO;
import org.scalsys.agile.service.ExoUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExoUtilServiceImpl implements ExoUtilService {

	@Autowired 
	private ExoUtilDAO exoUtilDAO;
	
	@Transactional
	public Long getRemoteUser() {
		
		return exoUtilDAO.getRemoteUser();
	}

}
