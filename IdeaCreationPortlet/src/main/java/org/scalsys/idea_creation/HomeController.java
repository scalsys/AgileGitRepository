package org.scalsys.idea_creation;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


import org.scalsys.agile.model.TestPojo;
import org.scalsys.idea_creation.model.AgileIdea;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RenderMapping
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@ModelAttribute("newIdea")
	public AgileIdea createBlankIdea(){
		System.out.println("new Idea object Created using Model Attribute Method.");
		return new AgileIdea();
	}
	
	@ActionMapping(params ="action=createIdeaAction")
	public void createIdea(@ModelAttribute AgileIdea newIdea){
		System.out.println("\n-----------------------New Idea Details --------------------\n");
		
		TestPojo testPojo = new TestPojo();
		System.out.println(testPojo.sayHello());
		String ideaId ="1";
		newIdea.setIdeaId(ideaId);
		String innoArena = "Innvation Arena";
		newIdea.setInnoArena(innoArena);
		String descriptorFilePath ="Descriptor File Path";
		newIdea.setDescriptorFilePath(descriptorFilePath);
		Date inventedDate = new Date();
		newIdea.setInventedDate(inventedDate);
		Long inventorId = 1l;
		newIdea.setInventorId(inventorId);
		
		
		
		System.out.println(newIdea);
		
	}
	
}
