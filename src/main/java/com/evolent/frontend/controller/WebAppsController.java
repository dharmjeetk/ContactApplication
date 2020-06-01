package com.evolent.frontend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evolent.frontend.dto.UIContactDTO;
import com.evolent.frontend.integration.ContactApplicationIntegration;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is UI Controller class for handling request and giving out in response
 * proper model view information
 * 
 * @author dharmjeet.kumar
 *
 */
@Controller
public class WebAppsController {

	private static final Logger logger = Logger.getLogger(WebAppsController.class);

	@GetMapping(value = "/contactApp")
	public String getAllContacts(Model model) {

		try {
			model.addAttribute("contact", new UIContactDTO());
			model.addAttribute("contacts", new ObjectMapper().readValue(
					ContactApplicationIntegration.getContactApplicationManagerResponse(RequestMethod.GET, null, null),
					new TypeReference<List<UIContactDTO>>() {
					}));
		} catch (Exception e) {
			logger.error("Exception occurred while displaying all contacts on UI due to " + e.getMessage());
			return "error";
		}

		return "contactDisplay";
	}

	// For add and update person both
	@PostMapping(value = "/contactApp/saveOrEdit")
	public String addPerson( @ModelAttribute("contact") @Validated UIContactDTO c,BindingResult bindingResult,Model model) {
		
		
		logger.info("new contact, bindingResult.hasErrors() :: "+ bindingResult.hasErrors());
		if (bindingResult.hasErrors()) {
			logger.info("Returning contactApp  page");
			return "redirect:/contactApp";
		}


		if (c.getContactId() == null || c.getContactId() == 0) {
			logger.info("new contact, add it");
			try {
				ContactApplicationIntegration.getContactApplicationManagerResponse(RequestMethod.POST, null,
						new ObjectMapper().writeValueAsString(c));
			} catch (Exception e) {
				logger.error("Exception occurred while saving contact on UI due to " + e.getMessage());
				return "error";
			}
		} else {
			logger.info("existing contact, call update");
			try {
				ContactApplicationIntegration.getContactApplicationManagerResponse(RequestMethod.PUT, null,
						new ObjectMapper().writeValueAsString(c));
			} catch (Exception e) {
				logger.error("Exception occurred while updating contact on UI due to " + e.getMessage());
				return "error";
			}
		}

		return "redirect:/contactApp";

	}

	@GetMapping(value = "/contactApp/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {
		ContactApplicationIntegration.getContactApplicationManagerResponse(RequestMethod.DELETE, id, null);
		return "redirect:/contactApp";
	}

	@GetMapping(value = "/contactApp/edit/{id}")
	public String editPerson(@PathVariable("id") int contactId, Model model) {
		try {
			model.addAttribute("contact", new ObjectMapper().readValue(ContactApplicationIntegration
					.getContactApplicationManagerResponse(RequestMethod.GET, contactId, null), UIContactDTO.class));
			model.addAttribute("contacts", new ObjectMapper().readValue(
					ContactApplicationIntegration.getContactApplicationManagerResponse(RequestMethod.GET, null, null),
					new TypeReference<List<UIContactDTO>>() {
					}));
		} catch (Exception e) {
			logger.error("Exception occurred while displaying all contacts on UI due to " + e.getMessage());
			return "error";
		}
		return "contactDisplay";
	}

	@ModelAttribute("statusList")
	public Map<String, String> getCountryList() {
		Map<String, String> statusList = new HashMap<>();
		statusList.put("ACTIVE", "ACTIVE");
		statusList.put("INACTIVE", "INACTIVE");
		return statusList;
	}
}