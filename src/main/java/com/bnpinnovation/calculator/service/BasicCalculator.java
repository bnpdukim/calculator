package com.bnpinnovation.calculator.service;

import org.springframework.stereotype.Service;

import com.bnpinnovation.calculator.dto.OperationResult;


@Service("basicCalculator")
public class BasicCalculator implements CalculatorService {

	private final int NOT_PERMITED_VALUE = 0;

	@Override
	public OperationResult plus(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand + rightOperand);
		return result;
	}

	@Override
	public OperationResult minus(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand - rightOperand);
		return result;
	}

	@Override
	public OperationResult multiply(int leftOperand, int rightOperand) {
		OperationResult result = new OperationResult();
		result.setValue(leftOperand * rightOperand);
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
		return result;
	}
}
