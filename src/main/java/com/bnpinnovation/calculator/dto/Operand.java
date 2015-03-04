package com.bnpinnovation.calculator.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Operand implements Serializable{
	private static final long serialVersionUID = -8309942401030717786L;	
	
	private int leftOperand;
	private int rightOperand;
	
	
	public int getLeftOperand() {
		return leftOperand;
	}
	
	@JsonProperty(value="left")
	public void setLeftOperand(String leftOperand) {
		this.leftOperand = Integer.parseInt(leftOperand);
	}
	
	public int getRightOperand() {
		return rightOperand;
	}

	@JsonProperty(value="right")
	public void setRightOperand(String rightOperand) {
		this.rightOperand = Integer.parseInt(rightOperand);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leftOperand;
		result = prime * result + rightOperand;
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
		Operand other = (Operand) obj;
		if (leftOperand != other.leftOperand)
			return false;
		if (rightOperand != other.rightOperand)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operand [leftOperand=" + leftOperand + ", rightOperand="
				+ rightOperand + "]";
	}

}
