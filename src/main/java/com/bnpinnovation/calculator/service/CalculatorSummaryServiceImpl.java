package com.bnpinnovation.calculator.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpinnovation.calculator.dao.CalculatorDao;
import com.bnpinnovation.calculator.domain.CalculatorOperation;
import com.bnpinnovation.calculator.dto.OperationSummary;

@Service
public class CalculatorSummaryServiceImpl implements CalculatorSummaryService {

	@Autowired
	private CalculatorDao calculatorSummaryDao;
	
	@Override
	@Transactional
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Set<OperationSummary> calculationSummary() {
		
		Set<OperationSummary> operationSummary = new HashSet<OperationSummary>();
		for(CalculatorOperation operation: calculatorSummaryDao.queryOperationSummary()) {
			operationSummary.add(new OperationSummary(operation));
		}
		
		return operationSummary;
	}

}
