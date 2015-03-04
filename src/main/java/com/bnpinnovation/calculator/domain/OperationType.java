package com.bnpinnovation.calculator.domain;

public enum OperationType {
	PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVISION("/");

	private final String operationSign;

	private OperationType(String operationSign) {
		this.operationSign = operationSign;
	}

	public String getOperationSign() {
		return operationSign;
	}

	public static OperationType valueFor(String operatoinSign) {
		OperationType type = null;
		switch (operatoinSign) {
		case "+":
			type=OperationType.PLUS;
			break;
		case "-":
			type=OperationType.MINUS;
			break;
		case "*":
			type=OperationType.MULTIPLY;
			break;
		case "/":
			type=OperationType.DIVISION;
			break;
		default:
			break;
		}
		return type;
	}
}
