package net.codejava.contact.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.codejava.contact.dao.IDatabaseOperation;
import net.codejava.contact.model.Contact;

@Controller
public class MainController {
	
	@Autowired
	private IDatabaseOperation contactDao; 
	
	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public ModelAndView listContact() {
		
		List<Contact> listContact = contactDao.list();
	
		System.out.println(listContact);
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("index");
		model.addObject("listContact", listContact);
		
		return model;
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newContact(@ModelAttribute("contact")Contact contact, ModelMap modelMap) {
		modelMap.put(BindingResult.MODEL_KEY_PREFIX + "contact", modelMap.get("errors"));
		return "newContact";
	}
	
	// create ve edit iþlemleri post olarak ayný action'ý kullanacak.
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result,
			RedirectAttributes redirectAttr) 
	{
		if(result.hasErrors()) {
			redirectAttr.addFlashAttribute("errors", result);
			redirectAttr.addFlashAttribute("contact", contact);
			return "redirect:/new";
		}
		Integer value = new Integer(contact.getId());
		if(contactDao.get(value) == null ) {
			contactDao.save(contact);
		}
		else {
			contactDao.update(contact);
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Contact contact = contactDao.get(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("newContact");
		model.addObject("contact", contact);
		
		return model;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam int id) {
		contactDao.delete(id);
		return new ModelAndView("redirect:/list");
	}
	
	
	
	

}
