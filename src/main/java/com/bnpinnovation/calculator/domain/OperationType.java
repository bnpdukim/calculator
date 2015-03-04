package com.bnpinnovation.calculator.domain;

public enum OperationType {
	PLUS("+"), MINUS("-"),MULTIPLY("*"),DIVISION("/");
	
	private final String operationSign;
	private OperationType(String operationSign) {
		this.operationSign = operationSign;
	}
	
	public String getOperationSign() {
		return operationSign;
	}
}
