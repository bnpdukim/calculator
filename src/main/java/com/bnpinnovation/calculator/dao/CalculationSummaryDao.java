package com.bnpinnovation.calculator.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bnpinnovation.calculator.domain.OperationSummary;

public interface CalculationSummaryDao {
	final String InsertOperation = 
	        "INSERT INTO operationSummary (operationType,leftOperand,rightOperand,result) "+
	        "VALUES( #{operationType}, #{leftOperand}, #{rightOperand}, #{result})";
	final String QueryOperation = 
		       "SELECT id, leftOperand, operationType, rightOperand, result, operationDate FROM operationSummary";
	
	@Insert(InsertOperation)
	void insertOperationSummary(OperationSummary summary);
	
	@Select(QueryOperation)
	@Results(value = {
            @Result(property="id", column="ID"),
            @Result(property="leftOperand", column="leftOperand"),
            @Result(property="operationType", column="operationType"),
            @Result(property="rightOperand", column="rightOperand"),
            @Result(property="result", column="result"),
            @Result(property="operationDate", column="operationDate")
        })
	List<OperationSummary> queryOperationSummary();
}
