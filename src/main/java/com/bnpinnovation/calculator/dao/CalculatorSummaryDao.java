package com.bnpinnovation.calculator.dao;

import org.apache.ibatis.annotations.Insert;

import com.bnpinnovation.calculator.domain.OperationSummary;

public interface CalculatorSummaryDao {
	final String INSERT = 
	        "INSERT INTO operationSummary (operationType,leftOperand,rightOperand,result) "+
	        "VALUES( #{operationType}, #{leftOperand}, #{rightOperand}, #{result})";
	
	
	@Insert(INSERT)
	void insertOperationSummary(OperationSummary summary);

}
