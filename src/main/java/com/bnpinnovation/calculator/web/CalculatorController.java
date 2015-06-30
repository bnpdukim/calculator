package com.bnpinnovation.calculator.web;

import java.security.Principal;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bnpinnovation.calculator.dto.Operand;
import com.bnpinnovation.calculator.dto.OperationResult;
import com.bnpinnovation.calculator.dto.OperationSummary;
import com.bnpinnovation.calculator.service.CalculatorService;
import com.bnpinnovation.calculator.service.CalculatorSummaryService;

@Controller
@RequestMapping(value = "/operation")
public class CalculatorController {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
	
	@Autowired
	@Qualifier("calculatorAndSave")
//	@Qualifier("basicCalculator")
	private CalculatorService calculator;
	@Autowired
	private CalculatorSummaryService calculatorSummaryService;
	
	@RequestMapping(value = "/plus", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OperationResult plus(@RequestBody Operand operand, Principal principal, Authentication authentication ) {
		logger.info(principal.getName());
		for(GrantedAuthority auth : authentication.getAuthorities() ) {
			logger.info(auth.getAuthority());
		}
		
		return calculator.plus(operand.getLeftOperand(), operand.getRightOperand());
	}
	
	@RequestMapping(value = "/minus", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OperationResult minus(@RequestBody Operand operand) {
		return calculator.minus(operand.getLeftOperand(), operand.getRightOperand());
	}
	
	@RequestMapping(value = "/multiply", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OperationResult multiply(@RequestBody Operand operand) {
		return calculator.multiply(operand.getLeftOperand(), operand.getRightOperand());
	}
	
	@RequestMapping(value = "/division", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OperationResult division(@RequestBody Operand operand) {		
		return calculator.devision(operand.getLeftOperand(), operand.getRightOperand());
	}

	
	@RequestMapping(value = "/summary", method = RequestMethod.GET, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Set<OperationSummary> summary() {
		return calculatorSummaryService.calculationSummary();
	}
}
