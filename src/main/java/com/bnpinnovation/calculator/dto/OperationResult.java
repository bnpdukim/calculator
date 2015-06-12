package com.bnpinnovation.calculator.dto;

import java.io.Serializable;

public class OperationResult implements Serializable {
	private static final long serialVersionUID = -9188183953406356437L;
	
	private int value;
	
	public void setValue(int value) {
		this.value = value;
		
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "OperationResult [value=" + value + "]";
	}	
}
