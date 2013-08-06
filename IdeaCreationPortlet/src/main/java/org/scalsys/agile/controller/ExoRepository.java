package org.scalsys.agile.controller;

import javax.jcr.Session;

import org.exoplatform.container.PortalContainer;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.jcr.config.RepositoryInfo;
import org.exoplatform.services.jcr.core.ManageableRepository;
import org.exoplatform.services.jcr.ext.common.SessionProvider;
import org.exoplatform.services.wcm.utils.WCMCoreUtils;
import org.exoplatform.webui.application.portlet.PortletApplicationController;


public class ExoRepository extends PortletApplicationController  {

    /**
	 * 
	 */

	public ExoRepository() throws Exception {
		
		// TODO Auto-generated constructor stub
	}

	public RepositoryInfo getJCRRepositoryInfo() {
		PortalContainer portalContainer = PortalContainer.getInstance();
		RepositoryService repositoryService = WCMCoreUtils
				.getService(RepositoryService.class);
		RepositoryInfo repositoryInfo = null;
		try {
			ManageableRepository manageableRepository = repositoryService
					.getCurrentRepository();
			SessionProvider sessionProvider = WCMCoreUtils
					.getUserSessionProvider();
			Session session = sessionProvider.getSession("portal-system",
					manageableRepository);

			System.out
					.println("\n-----------------------------------------------Repository Details ---------------------------------------\n");
			System.out.println("\nRepository StateTitle : "
					+ manageableRepository.getStateTitle());
			repositoryInfo = manageableRepository.getConfiguration();
			System.out.println("\nRepository info Name : "
					+ repositoryInfo.getName());
			System.out.println("\nRepository info System WorkSpace Name : "
					+ repositoryInfo.getSystemWorkspaceName());
			System.out.println("\nRepository info Defalut WorkSpace Name : "
					+ repositoryInfo.getDefaultWorkspaceName());
			System.out.println("\nRepository info Authentication Policy : "
					+ repositoryInfo.getAuthenticationPolicy());
			System.out.println("\nRepository info AccessControl :"
					+ repositoryInfo.getAccessControl());
			System.out
					.println("\n-----------------------------------------------Repository Details ---------------------------------------\n");
		} catch (javax.jcr.RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repositoryInfo;
	}
}