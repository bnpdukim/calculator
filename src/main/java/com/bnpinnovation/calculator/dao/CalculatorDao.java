package com.bnpinnovation.calculator.dao;

import java.util.Set;

import com.bnpinnovation.calculator.domain.CalculatorOperation;

public interface CalculatorDao {
	Long insertCalculatorOperation(CalculatorOperation operation);

	Set<CalculatorOperation> queryOperationSummary();
}
