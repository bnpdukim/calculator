package com.bnpinnovation.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpinnovation.calculator.dao.CalculatorDao;
import com.bnpinnovation.calculator.domain.CalculatorOperation;
import com.bnpinnovation.calculator.domain.OperationType;
import com.bnpinnovation.calculator.dto.OperationResult;


@Service("calculatorAndSave")
@Transactional
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
public class CalculatorAndSave implements CalculatorService {
	private final int NOT_PERMITED_VALUE = 0;

	@Autowired
	private CalculatorDao calculatorSummaryDao;
	
	@Override
	public OperationResult plus(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand + rightOperand);
		
		CalculatorOperation summary = createSummary(leftOperand, rightOperand,OperationType.PLUS,result);
		calculatorSummaryDao.insertCalculatorOperation( summary );
		
		return result;
	}


	@Override
	public OperationResult minus(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand - rightOperand);
		
		CalculatorOperation summary = createSummary(leftOperand, rightOperand,OperationType.MINUS,result);
		calculatorSummaryDao.insertCalculatorOperation( summary );
		
		return result;
	}

	@Override
	public OperationResult multiply(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand * rightOperand);
		
		CalculatorOperation summary = createSummary(leftOperand, rightOperand,OperationType.MULTIPLY,result);
		calculatorSummaryDao.insertCalculatorOperation( summary );
		
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
		
		CalculatorOperation summary = createSummary(leftOperand, rightOperand,OperationType.DIVISION,result);
		calculatorSummaryDao.insertCalculatorOperation( summary );
		return result;
	}
	
	private CalculatorOperation createSummary(int leftOperand, int rightOperand,
			OperationType operationType, OperationResult result) {
		CalculatorOperation summary = new CalculatorOperation();
		summary.setOperationType(operationType);
		summary.setLeftOperand(leftOperand);
		summary.setRightOperand(rightOperand);
		summary.setResult(result.getValue());
		return summary;
	}
}
