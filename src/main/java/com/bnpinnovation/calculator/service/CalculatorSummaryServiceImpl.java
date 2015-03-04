package com.bnpinnovation.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpinnovation.calculator.dao.CalculationSummaryDao;
import com.bnpinnovation.calculator.domain.OperationSummary;

@Service
public class CalculatorSummaryServiceImpl implements CalculatorSummaryService {

	@Autowired
	private CalculationSummaryDao calculatorSummaryDao;
	
	@Override
	public List<OperationSummary> queryCalculatorSummary() {
		return calculatorSummaryDao.queryOperationSummary();
	}

}
