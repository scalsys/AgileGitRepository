package org.scalsys.agile;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.scalsys.agile.model.Contest;
import org.scalsys.agile.model.Idea;
import org.scalsys.agile.model.IdeaCategory;
import org.scalsys.agile.model.IdeaDescriptorFile;
import org.scalsys.agile.model.IdeaSubcategory;
import org.scalsys.agile.model.IdeaType;
import org.scalsys.agile.model.IdeaVote;
import org.scalsys.agile.service.IdeaService;
import org.scalsys.agile.serviceImpl.IdeaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * Handles requests for the IdeaCreationPortlet view mode.
 */
@Controller
@RequestMapping("VIEW")
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RenderMapping
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is " + locale.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@ModelAttribute
	public void createIdeaDumy() {
		Idea idea = new Idea();
		idea.setCoinventorId(0);
		Contest contest = new Contest(0, "Contest Name", null);
		idea.setContest(contest);
		String description = "Idea Description";
		idea.setDescription(description);
		IdeaCategory ideaCategory = new IdeaCategory(0, "Category Name",null , null);
		idea.setIdeaCategory(ideaCategory);
		Set ideaDescriptorFiles = new HashSet<IdeaDescriptorFile>(0);
		idea.setIdeaDescriptorFiles(ideaDescriptorFiles);
		long ideaId=0;
		idea.setIdeaId(ideaId);
		IdeaSubcategory ideaSubcategory = new IdeaSubcategory();
		idea.setIdeaSubcategory(ideaSubcategory);
		String ideaTitle = "Idea Title";
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
		idea.setUpdatedDate(updatedDate);

		IdeaService ideaService = new IdeaServiceImpl();
		ideaService.createIdea(idea);
	}

	/*
	 * @ModelAttribute("newIdea") public Idea createBlankIdea() { System.out
	 * .println("new Idea object Created using Model Attribute Method."); return
	 * new Idea(); }
	 */

	@ActionMapping(params = "action=createIdeaAction")
	public void createIdea() {
		System.out
				.println("\n-----------------------New Idea Details --------------------\n");

		System.out.println("hello");

	}

}
