package com.bnpinnovation.calculator.service;

import java.util.Set;

import com.bnpinnovation.calculator.domain.CalculatorOperation;
import com.bnpinnovation.calculator.dto.OperationSummary;

public interface CalculatorSummaryService {

	Set<OperationSummary> calculationSummary();

}
