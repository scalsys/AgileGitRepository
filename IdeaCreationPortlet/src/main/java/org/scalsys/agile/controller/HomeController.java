package org.scalsys.agile.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.exoplatform.container.PortalContainer;
import org.exoplatform.portal.mop.description.SimpleDataCache;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.jcr.config.RepositoryInfo;
import org.exoplatform.services.jcr.core.ManageableRepository;
import org.exoplatform.services.jcr.ext.common.SessionProvider;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.wcm.utils.WCMCoreUtils;
import org.exoplatform.webui.core.UIPortletApplication;
import org.scalsys.agile.model.Contest;
import org.scalsys.agile.model.Idea;
import org.scalsys.agile.model.IdeaCategory;
import org.scalsys.agile.model.IdeaDescriptorFile;
import org.scalsys.agile.model.IdeaSubcategory;
import org.scalsys.agile.model.IdeaType;
import org.scalsys.agile.model.IdeaVote;
import org.scalsys.agile.service.ExoUtilService;
import org.scalsys.agile.service.IdeaCategoryService;
import org.scalsys.agile.service.IdeaContestService;
import org.scalsys.agile.service.IdeaFileDescriptorService;
import org.scalsys.agile.service.IdeaService;
import org.scalsys.agile.service.IdeaSubCategoryService;
import org.scalsys.agile.service.IdeaTypeService;
import org.scalsys.agile.service.IdeaVoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.ibm.icu.util.Calendar;


/**
 * Handles requests for the IdeaCreationPortlet view mode.
 */
@Controller
@RequestMapping("VIEW")
public class HomeController {

	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private IdeaTypeService ideaTypeService;
	
	@Autowired
	private IdeaCategoryService ideaCategoryService;
	
	@Autowired
	private IdeaContestService ideaContestService;
	
	@Autowired
	private IdeaVoteService ideaVoteService;
	
	@Autowired 
	private IdeaSubCategoryService ideaSubCategoryService;
	
	@Autowired
	private IdeaFileDescriptorService ideaFileDescriptorService;
	
	@Autowired
	private ExoUtilService exoUtilService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	 private static final Log LOG  = ExoLogger.getLogger(HomeController.class);


	@RenderMapping
	public String defaultRender(Locale locale, Model model,RenderRequest renderRequest) throws Exception {
		logger.info("Welcome home! the client locale is " + locale.toString());
         model.addAttribute("SubCategories",ideaSubCategoryService.listSubCategory());
         model.addAttribute("IdeaTypes",ideaTypeService.listIdeaType());
         model.addAttribute("IdeaVotes", ideaVoteService.listIdeaVote());
         model.addAttribute("IdeaContest",ideaContestService.listContest());
         model.addAttribute("Categories",ideaCategoryService.listCategory());
         System.out.println("idea categoty=======>"+ideaCategoryService.listCategory());
         System.out.println("idea Subcategory====>"+ideaSubCategoryService.listSubCategory());
         System.out.println("idea contest====>"+ideaContestService.listContest());
         System.out.println("idea Votes====>"+ideaVoteService.listIdeaVote());
         System.out.println("idea types====>"+ideaTypeService.listIdeaType());
         ExoRepository exoRepository = new ExoRepository();
         exoRepository.getJCRRepositoryInfo();
         /* ExoRepository exoRepository = new ExoRepository();
         exoRepository.getJCRRepositoryInfo();*/
		return "createidea";
	}
	
	@ActionMapping(params = "action=createIdea")
	public void createIdea(ActionRequest actionRequest,ActionResponse actionResponse) throws FileUploadException, IOException, RepositoryException {
		
		FileItemFactory factory = new DiskFileItemFactory();
	      PortletFileUpload portletFileUpload = new PortletFileUpload(factory);
	      List<FileItem> ideaItems=null;
	      ideaItems=portletFileUpload.parseRequest(actionRequest);
	  
	       String ideaTitle="";
	       String ContestId="";
	       String CategoryId="";
	       String subCategoryId ="";
	       String ideastage ="";
	       String TypeId ="";
	       String description="";
	       String appContext = "";
	       String appSpace="";
	       String name = "";
	       String uuid = "";
	       String path = "";
	       String fileName="";
	       boolean isDeleted = false;
	       boolean isPrivateContext = false;

	       for (FileItem ideaItem : ideaItems)
	      {
	        if (ideaItem.isFormField())
	        {
	               String fieldName = ideaItem.getFieldName();
	                 System.out.println("fileldname="+fieldName);
	               if ("ideaTitle".equals(fieldName))
	 	          {
	            	   ideaTitle = ideaItem.getString(); 
	 	          }
	               if ("ideaContest".equals(fieldName))
		 	          {
		            	 ContestId = ideaItem.getString(); 
		 	          }
	               if ("ideaCategory".equals(fieldName))
		 	          {
		            	  CategoryId = ideaItem.getString(); 
		 	          }
	               if ("ideasubCategory".equals(fieldName))
		 	          {
		            	   subCategoryId = ideaItem.getString(); 
		 	          }
	               if ("ideastage".equals(fieldName))
		 	          {
		            	  ideastage = ideaItem.getString(); 
		 	          }
	               if ("ideaType".equals(fieldName))
		 	          {
		            	 TypeId = ideaItem.getString(); 
		 	          }
	               if ("tinyeditor".equals(fieldName))
		 	          {
		            	 description = ideaItem.getString(); 
		            	 System.out.println("description"+description);
		 	          }
	               if ("app-context".equals(fieldName))
	 	          	  {
	            	   	appContext = ideaItem.getString();
	            	   	System.out.println("appContext="+appContext);
	            	   	isPrivateContext = "Personal".equals(appContext);
	            	   	System.out.println("isPrivateContext="+isPrivateContext);
	 	          	  }
	               if ("app-space".equals(fieldName))
	               	  {
	 	        	  	System.out.println("RemoteUser="+actionRequest.getRemoteUser());
	 	        	  	name = (isPrivateContext)?actionRequest.getRemoteUser():ideaItem.getString();
	 	        	  	System.out.println("name="+name);
	 	          }
	 	          if ("data-uuid".equals(fieldName)) 
	 	        	  {
	 	        	  	uuid = ideaItem.getString();
	 	        	  }
	 	         if ("app-filter".equals(fieldName)) 
	        	  {
	        	  		path = ideaItem.getString();
	        	  }
	          }
	 	         if (ideaItem.getFieldName().equals("ideafile"))
	 	          {
	 	        	System.out.println("\n#########################");
	 	          	System.out.println("######### UPLOAD ########");
	 	          	System.out.println("# name :: "+name);
	 	            System.out.println("# isPrivate :: "+isPrivateContext);
	 	            System.out.println("# uuid :: "+uuid);
	 	            System.out.println("# path ::"+path);
	                System.out.println("# item value :: "+ideaItem.getFieldName());
	                fileName = FilenameUtils.getName(ideaItem.getName());
	        		System.out.println("filename="+fileName);

	 	          if (uuid!=null)
	 	          {
	 	            storeFile(path, ideaItem, name, isPrivateContext, uuid, actionRequest);
	 	           System.out.println("File has been uploaded successfully!");
	 	          }
	 	          else
	 	          {
	 	            storeFile(path, ideaItem, name, isPrivateContext, actionRequest);
	 	            System.out.println("File has been uploaded successfully!");
	 	          }
	 	        }
	 	         
	 	          
	        	
	      }
	        Date ideaSubmissionDate = new Date(); 
			
			/*For Idea Vote*/
			Calendar cal =Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			Date startVoting = cal.getTime();
			Long ideaVoteId = ideaVoteService.getNextIdeaVoteId();
			IdeaVote ideaVote = new IdeaVote(ideaVoteId, startVoting);
			ideaVoteService.createIdeaVote(ideaVote);
			System.out.println("Vote insterted Sucessfully");
			
			/*For Idea Contest*/
			Long ideaContestId = Long.parseLong(ContestId);
			Contest ideaContest = ideaContestService.getIdeaContest(ideaContestId);
			
			/*For Idea Category*/
			Long ideaCategoryId = Long.parseLong(CategoryId);
			IdeaCategory ideaCategory = ideaCategoryService.getIdeaCategory(ideaCategoryId);
			
			/*For Idea SubCategory*/
			Long ideaSubCategoryId = Long.parseLong(subCategoryId);
			IdeaSubcategory ideaSubcategory = ideaSubCategoryService.getIdeaSubCategory(ideaSubCategoryId);
			
			/*For Idea Type*/
			Long ideaTypeId = Long.parseLong(TypeId);
			IdeaType ideaType = ideaTypeService.getIdeaType(ideaTypeId);
			
			/*For Co-invetor*/
			Long conInvetorId = exoUtilService.getRemoteUser();
			
			
			/*Inserting Idea */
			Long ideaId = ideaService.getNextIdeaId();
			Idea idea =  new Idea(ideaId, ideaVote, ideaSubcategory, ideaContest, ideaType, ideaCategory, ideaTitle, description, isDeleted, ideaSubmissionDate, ideaSubmissionDate, ideastage, conInvetorId, null);
			ideaService.createIdea(idea);
           
			/*For Idea Descriptor File*/
			Long ideaFileId = ideaFileDescriptorService.getNextIdeaId();
			IdeaDescriptorFile ideaDescriptorFile = new IdeaDescriptorFile(ideaFileId,idea,fileName);
	        ideaFileDescriptorService.saveIdeaFile(ideaDescriptorFile);
			
			/*For Idea File*/
			
			System.out.println("Idea created sucessfully");
	        actionResponse.setRenderParameter("jspPage", "home");
	     
		
		/*String ideaTitle = actionRequest.getParameter("ideaTitle");
		String ContestId = actionRequest.getParameter("ideaContest");
		String CategoryId = actionRequest.getParameter("ideaCategory");
		String subCategoryId = actionRequest.getParameter("ideasubCategory");
		String ideastage = actionRequest.getParameter("ideastage");
		String TypeId = actionRequest.getParameter("ideaType");
		String description = actionRequest.getParameter("description");
		String appContext = actionRequest.getParameter("app-context");
	    String path = actionRequest.getParameter("app-filter");
	    boolean isPrivateContext = "Personal".equals(appContext);
	    String name = (isPrivateContext)?actionRequest.getRemoteUser():actionRequest.getParameter("app-space");
		boolean isDeleted = false;
		System.out.println("ideatitle==>"+ideaTitle);
        System.out.println("ContestId==========>>>>>"+ContestId);
		Date ideaSubmissionDate = new Date(); 
		
		For Idea Vote
		Calendar cal =Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		Date startVoting = cal.getTime();
		Long ideaVoteId = ideaVoteService.getNextIdeaVoteId();
		IdeaVote ideaVote = new IdeaVote(ideaVoteId, startVoting);
		ideaVoteService.createIdeaVote(ideaVote);
		System.out.println("Vote insterted Sucessfully");
		
		For Idea Contest
		Long ideaContestId = Long.parseLong(ContestId);
		Contest ideaContest = ideaContestService.getIdeaContest(ideaContestId);
		
		For Idea Category
		Long ideaCategoryId = Long.parseLong(CategoryId);
		IdeaCategory ideaCategory = ideaCategoryService.getIdeaCategory(ideaCategoryId);
		
		For Idea SubCategory
		Long ideaSubCategoryId = Long.parseLong(subCategoryId);
		IdeaSubcategory ideaSubcategory = ideaSubCategoryService.getIdeaSubCategory(ideaSubCategoryId);
		
		For Idea Type
		Long ideaTypeId = Long.parseLong(TypeId);
		IdeaType ideaType = ideaTypeService.getIdeaType(ideaTypeId);
		
		For Co-invetor
		Long conInvetorId = exoUtilService.getRemoteUser();
		
		
		Inserting Idea 
		Long ideaId = ideaService.getNextIdeaId();
		Long ideaFileId = ideaFileDescriptorService.getNextIdeaId();
		IdeaDescriptorFile ideaDescriptorFile = new IdeaDescriptorFile();
		ideaDescriptorFile.setFileId(ideaFileId);
		ideaDescriptorFile.setFileName("AITlogo.png");
		Set<IdeaDescriptorFile> ideaDescriptorFiles = new HashSet<IdeaDescriptorFile>(); 
		ideaDescriptorFiles.add(ideaDescriptorFile);
		Idea idea =  new Idea(ideaId, ideaVote, ideaSubcategory, ideaContest, ideaType, ideaCategory, ideaTitle, description, isDeleted, ideaSubmissionDate, ideaSubmissionDate, ideastage, conInvetorId, ideaDescriptorFiles);
		ideaService.createIdea(idea);*/
		
		/*For Idea File*/
		
	}

	@RenderMapping(params = "view=file")
	public String fileURL(RenderRequest renderRequest,RenderResponse renderResponse)
	{
		return "file";
	}
	
	@SuppressWarnings("unchecked")
	@ActionMapping(params = "action=saveFile")
	public void saveFile(ActionRequest actionRequest,ActionResponse actionResponse) throws FileUploadException, IOException, RepositoryException
	{
		String appContext = actionRequest.getParameter("app-context");
		System.out.println("appContext"+appContext);
	    String path = actionRequest.getParameter("app-filter");
	    boolean isPrivateContext = "Personal".equals(appContext);
	    String name = (isPrivateContext)?actionRequest.getRemoteUser():actionRequest.getParameter("app-space");
	    String uuid = null;
	   
	      FileItemFactory factory = new DiskFileItemFactory();
	      PortletFileUpload portletFileUpload = new PortletFileUpload(factory);
	      List<FileItem> items2=null;
	      items2=portletFileUpload.parseRequest(actionRequest);
	      for (FileItem item : items2)
	      {
	        if (item.isFormField())
	        {
	          String fieldName = item.getFieldName();
	          System.out.println("fileldName="+fieldName);
	          if ("app-context".equals(fieldName))
	          {
	            appContext = item.getString();
	            System.out.println("appContext="+appContext);
	            isPrivateContext = "Personal".equals(appContext);
	            System.out.println("isPrivateContext="+isPrivateContext);
	          }
	          if ("app-space".equals(fieldName))
	          {
	        	  System.out.println("RemoteUser="+actionRequest.getRemoteUser());
	            name = (isPrivateContext)?actionRequest.getRemoteUser():item.getString();
	            System.out.println("name="+name);
	          }
	          if ("data-uuid".equals(fieldName)) uuid = item.getString();
	          if ("app-filter".equals(fieldName)) path = item.getString();

	        }
	        if (item.getFieldName().equals("pic"))
	        {
              System.out.println("\n#########################");
	          System.out.println("######### UPLOAD ########");
	          System.out.println("# name :: "+name);
	          System.out.println("# isPrivate :: "+isPrivateContext);
	          System.out.println("# uuid :: "+uuid);
	          System.out.println("# path ::"+path);
              System.out.println("# item value :: "+item.getFieldName());

	          if (uuid!=null)
	          {
	            storeFile(path, item, name, isPrivateContext, uuid, actionRequest);
	           System.out.println("File has been uploaded successfully!");
	           actionResponse.setRenderParameter("jspPage", "/WEB-INF/jsps/createidea.jsp");
	          }
	          else
	          {
	            storeFile(path, item, name, isPrivateContext, actionRequest);
	            System.out.println("File has been uploaded successfully!");
	            actionResponse.setRenderParameter("jspPage", "/WEB-INF/jsps/createidea.jsp");
	          }
	        }
	      }
	   
	}

	private void storeFile(String path, FileItem item, String name,
			boolean isPrivateContext, ActionRequest actionRequest) throws RepositoryException {
		storeFile(path, item, name, isPrivateContext, null, actionRequest);
		
	}

	private void storeFile(String path, FileItem item, String name,
			boolean isPrivateContext, String uuid, ActionRequest actionRequest) throws RepositoryException {
		System.out.println("pathinStore"+path);
		System.out.println("iteminStore"+item);
		System.out.println("nameinStore"+name);
		System.out.println("isPrivateContextinStore"+isPrivateContext);
		System.out.println("uuidinStore"+uuid);
		String filename = FilenameUtils.getName(item.getName());
		System.out.println("filename="+filename);
		PortalContainer portalContainer = PortalContainer.getInstance();
		RepositoryService repositoryService = WCMCoreUtils.getService(RepositoryService.class);
		RepositoryInfo repositoryInfo = null;
		ManageableRepository manageableRepository = repositoryService.getCurrentRepository();
		repositoryInfo = manageableRepository.getConfiguration();
        SessionProvider sessionProvider = WCMCoreUtils.getUserSessionProvider();
		//RepositoryService repositoryService = (RepositoryService)PortalContainer.getInstance().getComponentInstanceOfType(RepositoryService.class);
	    NodeHierarchyCreator nodeHierarchyCreator = (NodeHierarchyCreator)PortalContainer.getInstance().getComponentInstanceOfType(NodeHierarchyCreator.class);
	   // SessionProvider sessionProvider = SessionProvider.createSystemProvider();
	    try
	    {
	      //get info
	      System.out.println("intry"+repositoryService);
	      System.out.println("Repository="+repositoryInfo.getName());
	      System.out.println("DefaultWorkSpace="+repositoryInfo.getDefaultWorkspaceName());
	     // Session session = sessionProvider.getSession("collaboration", repositoryService.getCurrentRepository());
	      Session session = sessionProvider.getSession("collaboration",
					manageableRepository);
          System.out.println("WorkSpace="+session.getWorkspace());
	      Node homeNode;

	      if (isPrivateContext)
	      {
	        Node userNode = nodeHierarchyCreator.getUserNode(sessionProvider, name);
	        System.out.println("UserNode="+userNode);
	        homeNode = userNode.getNode("Private");
	        System.out.println("homeNode="+homeNode);
	      }
	      else
	      {
	        Node rootNode = session.getRootNode();
	        System.out.println("RootNode="+rootNode);
	        homeNode = rootNode.getNode(getSpacePath(name));
	        System.out.println("homeNode="+homeNode);
	      }
	      
	      /*Node docNode = homeNode.getNode("sites");
	      if (path.contains("/") && !path.startsWith("intranet/documents/Folksonomy/")) {
	        docNode = homeNode.getNode(path);
	        System.out.println("docNode="+docNode);
	      }*/
	      if (!homeNode.hasNode(filename) && (uuid==null || "agile1".equals(uuid)))
	      {
	        Node fileNode = homeNode.addNode(filename, "nt:file");
	        System.out.println("fileNode="+fileNode);
	        Node jcrContent = fileNode.addNode("jcr:content", "nt:resource");
	        jcrContent.setProperty("jcr:data", item.getInputStream());
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	        System.out.println("Today Date="+new Date());
	        String date = simpleDateFormat.format(new Date());
	        System.out.println("Date ="+date);
	        jcrContent.setProperty("jcr:lastModified",date);
	        jcrContent.setProperty("jcr:encoding", "UTF-8");
	        System.out.println("jCRContent="+jcrContent);
	        if (filename.endsWith(".jpg"))
	          jcrContent.setProperty("jcr:mimeType", "image/jpeg");
	        else if (filename.endsWith(".png"))
	          jcrContent.setProperty("jcr:mimeType", "image/png");
	        else if (filename.endsWith(".pdf"))
	          jcrContent.setProperty("jcr:mimeType", "application/pdf");
	        else if (filename.endsWith(".doc"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.ms-word");
	        else if (filename.endsWith(".xls"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.ms-excel");
	        else if (filename.endsWith(".ppt"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.ms-powerpoint");
	        else if (filename.endsWith(".docx"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	        else if (filename.endsWith(".xlsx"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        else if (filename.endsWith(".pptx"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
	        else if (filename.endsWith(".odp"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.oasis.opendocument.presentation");
	        else if (filename.endsWith(".odt"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.oasis.opendocument.text");
	        else if (filename.endsWith(".ods"))
	          jcrContent.setProperty("jcr:mimeType", "application/vnd.oasis.opendocument.spreadsheet");
	        fileNode.setProperty("exo:lastModifier", actionRequest.getRemoteUser());
	        System.out.println("in exo last modifier");
	       /* DocumentsData.updateTimestamp(homeNode);
	        System.out.println("update timestamp home node");
	        DocumentsData.updateSize(homeNode);
	        System.out.println("update size home node");
	        DocumentsData.updateTimestamp(homeNode.getParent());
	        System.out.println("update timestamp home node parent");*/
	        session.save();
	        uuid = fileNode.getUUID();
	        System.out.println("uuid="+uuid);
	      }
	      else
	      {
	        Node fileNode=null;
	    
	          	fileNode = homeNode.getNode(filename);
	          	System.out.println("filenode in else"+fileNode);
	          	Node jcrContent = fileNode.getNode("jcr:content");
		        System.out.println("jcrContent"+fileNode.getNode("jcr:content"));
		        jcrContent.setProperty("jcr:data", item.getInputStream());
		        System.out.println("jcrdata"+fileNode.getNode("jcr:content"));
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		        System.out.println("Today Date="+new Date());
		        String date = simpleDateFormat.format(new Date());
		        System.out.println("Date ="+date);
		        jcrContent.setProperty("jcr:lastModified",date);
		        jcrContent.setProperty("jcr:encoding", "UTF-8");
		        System.out.println("jCRContent="+jcrContent);
		        fileNode.save();
		        session.save();
		        uuid = fileNode.getUUID();
		        System.out.println("uuid="+uuid);
	        }
	    
	      if (path.startsWith("Folksonomy/")) {
	          if (uuid!=null)
	          {
	        	  System.out.println("pathstartswith"+path.startsWith("Folksonomy/"));
	            if (!isPrivateContext)
	              path = path.replace("Folksonomy/", "ApplicationData/Tags/");
	            //Node fileNode = session.getNodeByUUID(uuid);
	            Node tagNode = homeNode.getNode(path);
	            Node linkNode = tagNode.addNode(filename, "exo:symlink");
	            linkNode.setProperty("exo:uuid", uuid);
	            linkNode.setProperty("exo:workspace", "collaboration");
	            linkNode.setProperty("exo:primaryType", "nt:file");
	            tagNode.save();
	            DocumentsData.updateTimestamp(tagNode);
	            DocumentsData.updateTimestamp(tagNode.getParent());
	            DocumentsData.updateTimestamp(homeNode);

	            session.save();

	          }
	        }

	      }
	      catch (Exception e)
	      {
	        System.out.println("JCR::" + e.getMessage());
//	        e.printStackTrace();
	      }
	      finally
	      {
	       /* sessionProvider.close();*/
	      }
	    }

	    private boolean isImage(String filename)
	    {
	      if (filename.endsWith(".jpg") || filename.endsWith(".png"))
	        return true;
	      return false;
	    }
	private String getSpacePath(String space) {
		
		return "Groups/spaces/"+space;
	}
	
}