package com.bnpinnovation.calculator.service;

import com.bnpinnovation.calculator.dto.OperationResult;

public interface CalculatorService {

	OperationResult plus(int leftOperand, int rightOperand);

	OperationResult minus(int leftOperand, int rightOperand);

	OperationResult multiply(int leftOperand, int rightOperand);

	OperationResult devision(int leftOperand, int rightOperand);

}
