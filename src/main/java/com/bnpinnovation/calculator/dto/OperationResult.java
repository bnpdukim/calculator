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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationResult other = (OperationResult) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OperationResult [value=" + value + "]";
	}	
}
