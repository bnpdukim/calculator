package com.bnpinnovation.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpinnovation.calculator.dao.CalculationSummaryDao;
import com.bnpinnovation.calculator.domain.OperationSummary;
import com.bnpinnovation.calculator.domain.OperationType;
import com.bnpinnovation.calculator.dto.OperationResult;


@Service("summaryCalculator")
public class SummaryCalculator implements CalculatorService {
	private final int NOT_PERMITED_VALUE = 0;

	@Autowired
	private CalculationSummaryDao calculatorSummaryDao;
	
	@Override
	public OperationResult plus(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand + rightOperand);
		
		OperationSummary summary = createSummary(leftOperand, rightOperand,OperationType.PLUS,result);
		calculatorSummaryDao.insertOperationSummary( summary );
		
		return result;
	}


	@Override
	public OperationResult minus(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand - rightOperand);
		
		OperationSummary summary = createSummary(leftOperand, rightOperand,OperationType.MINUS,result);
		calculatorSummaryDao.insertOperationSummary( summary );
		
		return result;
	}

	@Override
	public OperationResult multiply(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand * rightOperand);
		
		OperationSummary summary = createSummary(leftOperand, rightOperand,OperationType.MULTIPLY,result);
		calculatorSummaryDao.insertOperationSummary( summary );
		
		return result;
	}

	@Override
	public OperationResult devision(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		if(rightOperand != NOT_PERMITED_VALUE ) {
			result.setValue(leftOperand / rightOperand);
		} else {
			result.setValue(0);
		}
		
		OperationSummary summary = createSummary(leftOperand, rightOperand,OperationType.DIVISION,result);
		calculatorSummaryDao.insertOperationSummary( summary );
		return result;
	}
	
	private OperationSummary createSummary(int leftOperand, int rightOperand,
			OperationType operationType, OperationResult result) {
		OperationSummary summary = new OperationSummary();
		summary.setOperationType(operationType);
		summary.setLeftOperand(leftOperand);
		summary.setRightOperand(rightOperand);
		summary.setResult(result.getValue());
		return summary;
	}
}
