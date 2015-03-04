package com.bnpinnovation.calculator.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bnpinnovation.calculator.dto.Operand;
import com.bnpinnovation.calculator.dto.OperationResult;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/operand")
public class CalculatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
	
	@RequestMapping(value = "/plus", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OperationResult plus(@RequestBody Operand operand) {
		OperationResult result = new OperationResult();
		result.setValue( (int) (operand.getLeftOperand() + operand.getRightOperand()) );
		
		logger.info( "operand left : " + operand.getLeftOperand()+ ", right : " + operand.getRightOperand() );
		logger.info( "result : " + result.getValue() );
		
		return result;
	}
	
	@RequestMapping(value = "/minus", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OperationResult minus(@RequestBody Operand operand) {
		OperationResult result = new OperationResult();
		result.setValue( (int) (operand.getLeftOperand() - operand.getRightOperand()) );
		
		return result;
	}
	
	@RequestMapping(value = "/multiply", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OperationResult multiply(@RequestBody Operand operand) {
		OperationResult result = new OperationResult();
		result.setValue( (int)(operand.getLeftOperand() * operand.getRightOperand()) );
		
		return result;
	}
	
	@RequestMapping(value = "/division", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OperationResult division(@RequestBody Operand operand) {
		OperationResult result = new OperationResult();
		if( operand.getRightOperand() != 0 ) {
			result.setValue( (int)(operand.getLeftOperand() / operand.getRightOperand()) );			
		} else {
			result.setValue( 0 );
		}
		
		return result;
	}
}
