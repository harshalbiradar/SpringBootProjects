package com.springboot.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.constant.AppConstants;
import com.springboot.entity.Contact;
import com.springboot.props.AppProperties;
import com.springboot.service.ContactService;

@Controller
public class ContactController {

	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;

	@Autowired
	private AppProperties appProps;
	
	
	private Validator validator;

	@GetMapping({ "/", "/home" })
	public String homePage() {
		return "homePage";
	}
	
	
	//@GetMapping("/addContact")
	@RequestMapping("/addContact")
	public String contactPage(Model model) {
		logger.debug("*****contactPage() execution is started*****");
		model.addAttribute(AppConstants.CONTACT_MODEL, new Contact());// we are sending empty obj to view
		logger.debug("*****contactPage() execution is completed*****");
		logger.info("*****contactPage() executed successfully*****");
		return AppConstants.CONTACT_VIEW;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//it will execute first
		//before the data binding if you want to modify the  binding object
		System.out.println("I am inside initBinder ");
		//binder.setDisallowedFields("contactName");
		/*
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class,"date", customDateEditor);
		*/
		/*
		NumberFormat numberFormat = new DecimalFormat("##,###.00");
		CustomNumberEditor editor = new CustomNumberEditor(BigDecimal.class,numberFormat, true);
		binder.registerCustomEditor(BigDecimal.class,"amount", editor);
		*/
	}
	
	
	
	@PostMapping("/addContact")
	public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult errors, RedirectAttributes attributes) {
		//it will execute later
		logger.debug("*****addContact() execution is started*****");
		if (errors.hasErrors()) {
				List<ObjectError> allErrors = errors.getAllErrors();
				for (ObjectError objectError : allErrors) {
					System.out.println("objectError:: -"+objectError);
				}
			return "contactInfo";
		}
		
		
		Map<String, String> messages = appProps.getMessages();

		contact.setContactIsActive(true);
		String resultMsg;

		if (contact.getContactId() == null) {
			resultMsg = messages.get(AppConstants.SAVE_SUCC);
		} else {
			logger.info("*****Contact updated successfully*****");
			resultMsg = messages.get(AppConstants.UPDATE_SUCC);
		}
		boolean result = contactService.addContact(contact);
		if (result == true) {
			logger.info("*****Contact saved successfully*****");
			attributes.addFlashAttribute("successMsg", resultMsg);
		} else {
			logger.info("*****Contact save failed*****");
			attributes.addFlashAttribute("errorMsg", messages.get(AppConstants.SAVE_FAIL));
		}

		attributes.addFlashAttribute("message", resultMsg);
		logger.debug("*****addContact() execution is completed*****");
		logger.info("*****addContact() executed successfully*****");
		return "redirect:/contactCreatedSuccessfully";

	}

	// for double posting how to redirect url to get method
	@GetMapping("/contactCreatedSuccessfully")
	public String doublePostingMsg(Model model) {
		model.addAttribute(AppConstants.CONTACT_MODEL, new Contact());// we have the arribute on jsp page for binding
		return AppConstants.CONTACT_VIEW;
	}

	@GetMapping("/getAllContacts")
	public ModelAndView getContacts(Model model) {
		return getListByPage(1, model);
	}
	
	
	@GetMapping("/page/{pageNumber}")
	public ModelAndView getListByPage(@PathVariable("pageNumber") int currentPage, Model model) {
		logger.info("*****getContacts() execution is started*****");
		
		Page<Contact> page = contactService.getAllContacts(currentPage);
		
		long totalElements = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		List<Contact> listContacts = page.getContent();
		logger.info("*****getContacts() execution is completed*****");
		logger.info("*****getContacts() executed successfully*****");
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalElements", totalElements);
		return new ModelAndView("viewContacts", "allContacts", listContacts);
	}
	
	
	
	
	@GetMapping("/getFilterContacts")
	public ModelAndView getFilterContacts(@RequestParam("keyword")String keyword, Model model) {
		logger.info("*****getContacts() execution is started*****");
		List<Contact> listContacts = contactService.getFilterContacts(keyword);
		logger.info("*****getContacts() execution is completed*****");
		logger.info("*****getContacts() executed successfully*****");
		return new ModelAndView("viewContacts", "allContacts", listContacts);
	}

	@GetMapping("/updateContact")
	public String updateContact(@RequestParam("contactId") Integer contactId, Model model) {
		logger.info("*****updateContact() execution is started*****");
		Contact updateContact = contactService.getContactById(contactId);
		model.addAttribute(AppConstants.CONTACT_MODEL, updateContact);
		logger.info("*****updateContact() execution is completed*****");
		logger.info("*****updateContact() executed successfully*****");
		return AppConstants.CONTACT_VIEW;
	}

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable Integer id, RedirectAttributes attributes) {
		/* @RequestParam("contactId") */
		logger.info("*****deleteContact() execution is started*****");
		Map<String, String> messages = appProps.getMessages();

		String resultMsg;
		boolean deleteContact = contactService.deleteContact(id);

		if (deleteContact == true) {
			logger.info("*****Contact deleted successfully*****");
			resultMsg = messages.get(AppConstants.DELETE_SUCC);
		} else {
			logger.info("*****Contact fail to delete*****");
			resultMsg = messages.get(AppConstants.DELETE_FAIL);
		}
		attributes.addFlashAttribute("deleteMsg", resultMsg);
		logger.info("*****deleteContact() execution is completed*****");
		logger.info("*****deleteContact() executed successfully*****");
		return "redirect:/getAllContacts";
	}
	
	
	
	
	

}
