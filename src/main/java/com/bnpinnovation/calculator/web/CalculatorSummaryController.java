package com.bnpinnovation.calculator.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bnpinnovation.calculator.domain.OperationSummary;
import com.bnpinnovation.calculator.dto.Operand;
import com.bnpinnovation.calculator.service.CalculatorSummaryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CalculatorSummaryController {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorSummaryController.class);
	
	@Autowired
	private CalculatorSummaryService calculatorSummaryServer;
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<OperationSummary> summary() {
		return calculatorSummaryServer.queryCalculatorSummary();
	}
}
