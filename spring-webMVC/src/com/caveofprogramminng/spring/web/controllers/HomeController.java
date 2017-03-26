package com.caveofprogramminng.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.caveofprogramminng.spring.web.dao.Offer;
import com.caveofprogramminng.spring.web.dao.OffersDAO;
import com.caveofprogramminng.spring.web.service.OffersService;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showOffers() {	
		
		System.out.println("In home controller");
		return "home";
	}
	
}

