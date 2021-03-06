package com.bnpinnovation.calculator.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class WebAppController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebAppController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String calculator() {
		return "app";
	}	
}
