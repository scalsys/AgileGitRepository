package org.scalsys.agile.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;

import org.exoplatform.webui.application.portlet.PortletApplicationController;
import org.scalsys.agile.model.Contest;
import org.scalsys.agile.model.Idea;
import org.scalsys.agile.model.IdeaCategory;
import org.scalsys.agile.model.IdeaDescriptorFile;
import org.scalsys.agile.model.IdeaSubcategory;
import org.scalsys.agile.model.IdeaType;
import org.scalsys.agile.model.IdeaVote;
import org.scalsys.agile.service.IdeaService;
import org.scalsys.agile.service.IdeaTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * Handles requests for the IdeaCreationPortlet view mode.
 */
@Controller
@RequestMapping("VIEW")
public class HomeController extends PortletApplicationController {
    
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private IdeaTypeService ideaTypeService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RenderMapping
	public String home(Locale locale, Model model,RenderRequest renderRequest) {
		logger.info("Welcome home! the client locale is " + locale.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	
/*	public void createIdeaDumy(String ideaTitle, String description) {
		Idea idea = new Idea();
		idea.setCoinventorId(0);
		Contest contest = new Contest(1, "EliteContest");
		idea.setContest(contest);
		idea.setDescription(description);
		IdeaSubcategory ideaSubcategory = new IdeaSubcategory();
		idea.setIdeaSubcategory(ideaSubcategory);
		IdeaCategory ideaCategory = new IdeaCategory(1, "Category",null,null);
		System.out.println("ideacategory=" +ideaCategory.getCategoryId());
		System.out.println("categoryname="+ ideaCategory.getCategoryName());
		idea.setIdeaCategory(ideaCategory);
		Set<IdeaDescriptorFile> ideaDescriptorFiles = new HashSet<IdeaDescriptorFile>();
		idea.setIdeaDescriptorFiles(ideaDescriptorFiles);
		long ideaId = 0;
		idea.setIdeaId(ideaId);
		idea.setIdeaTitle(ideaTitle);
		IdeaType ideaType=new IdeaType("Developing");
		idea.setIdeaType(ideaType);
		IdeaVote ideaVote = new IdeaVote(1,new Date());
		idea.setIdeaVote(ideaVote);
		boolean isDeleted=false;
		idea.setIsDeleted(isDeleted);
		String stage = "Stage";
		idea.setStage(stage);
		Date submissionDate = new Date();
		idea.setSubmissionDate(submissionDate);
		Date updatedDate = new Date();
		idea.setUpdatedDate(updatedDate);
		ideaService.createIdea(idea);
	}*/
	/*
	 * @ModelAttribute("newIdea") public Idea createBlankIdea() { System.out
	 * .println("new Idea object Created using Model Attribute Method."); return
	 * new Idea(); }
	 */

	@ActionMapping(params = "action=createIdeaAction")
	public void createIdea(ActionRequest actionRequest,ActionResponse actionResponse) {
		System.out
				.println("\n-----------------------New Idea Details --------------------\n");
        System.out.println("hello");
        String ideaTypeId = actionRequest.getParameter("ideaTypeId");
        String ideaTypeName = actionRequest.getParameter("ideaTypeName");
        System.out.println("ideaTypeId="+ideaTypeId);
        System.out.println("ideaTypeName="+ideaTypeName);
        IdeaType ideaType = new IdeaType(ideaTypeName);
        ideaTypeService.createIdeaType(ideaType);
        System.out.println("IdeaType created sucessfully");
       /*String ideaTitle = actionRequest.getParameter("ideaTitle");
        String description = actionRequest.getParameter("description");
        createIdeaDumy(ideaTitle,description);*/
		/*idea.setCoinventorId(0);
		Contest contest = new Contest(0, "Contest Name", null);
		idea.setContest(contest);
		idea.setDescription(description);
		IdeaCategory ideaCategory = new IdeaCategory(0, "Category Name",null , null);
		idea.setIdeaCategory(ideaCategory);
		Set ideaDescriptorFiles = new HashSet<IdeaDescriptorFile>(0);
		idea.setIdeaDescriptorFiles(ideaDescriptorFiles);
		long ideaId=0;
		idea.setIdeaId(ideaId);
		IdeaSubcategory ideaSubcategory = new IdeaSubcategory();
		idea.setIdeaSubcategory(ideaSubcategory);
		idea.setIdeaTitle(ideaTitle);
		IdeaType ideaType=new IdeaType();
		idea.setIdeaType(ideaType);
		IdeaVote ideaVote = new IdeaVote();
		idea.setIdeaVote(ideaVote);
		boolean isDeleted=false;
		idea.setIsDeleted(isDeleted);
		String stage = "Satage";
		idea.setStage(stage);
		Date submissionDate = new Date();
		idea.setSubmissionDate(submissionDate);
		Date updatedDate = new Date();
		idea.setUpdatedDate(updatedDate);*/
		/*boolean isIdeaCreated =false;
	    isIdeaCreated = ideaService.createIdea(idea);
	    System.out.println("IsIdeaCreated="+isIdeaCreated);*/
		/*System.out.println("Idea created sucessfully");*/
        actionResponse.setRenderParameter("jspPage", "home");
        

	}

}
