package com.bnpinnovation.calculator.dto;

import java.io.Serializable;

import com.bnpinnovation.calculator.domain.CalculatorOperation;

public class OperationSummary implements Serializable {
	private static final long serialVersionUID = -1897395771536370536L;
	
	private Long id;
	private String operationType;
	private int leftOperand;
	private int rightOperand;
	private int result;
	private String operationDate;
	
	public OperationSummary() {
	}
	public OperationSummary(CalculatorOperation operation) {
		id = operation.getId();
		operationType = operation.getOperationType();
		leftOperand = operation.getLeftOperand();
		rightOperand = operation.getRightOperand();
		result = operation.getResult();
		operationDate = operation.getVisibleDate();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public int getLeftOperand() {
		return leftOperand;
	}
	public void setLeftOperand(int leftOperand) {
		this.leftOperand = leftOperand;
	}
	public int getRightOperand() {
		return rightOperand;
	}
	public void setRightOperand(int rightOperand) {
		this.rightOperand = rightOperand;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}
}
