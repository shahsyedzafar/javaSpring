package com.caveofprogramminng.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caveofprogramminng.spring.web.dao.Offer;
import com.caveofprogramminng.spring.web.service.OffersService;

@Controller
public class OffersController {
	
	
	private OffersService offersService;
	
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		
		System.out.println("Printing offersService in controller" + offersService);
		this.offersService = offersService;
	}
	
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id")String id) {
		
		System.out.println("Id received is " + id);
		return "home";
	}
	
	/*
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException dae) {
		return "error";
	}
	*/
	@RequestMapping("/offers")
	public String showOffers(Model model) {

		//offersService.throwTestException();
		
		List<Offer> offers = offersService.getCurrent();		
		model.addAttribute("offers", offers);
		System.out.println("Offer List in controlloer: " + offers);
		return "offers";
	}
	
	
	@RequestMapping("/createOffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer",new Offer());
		return "createOffer";
	}
	
	@RequestMapping(value="/doCreate", method=RequestMethod.POST)
	public String Offercreated(Model model, @Valid Offer offer,  BindingResult result) {
		
		if(result.hasErrors()) {
			
			List<ObjectError> errors = result.getAllErrors();
			
			System.out.println("Form did not validatate");
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "createOffer";
		} else {
			
			System.out.println("Form validated");
		}
		
		System.out.println("Offer Created in post: " + offer);
		
		offersService.createOffer(offer);
	
		
		return "offerCreated";
	}
	
	
	
	


}
