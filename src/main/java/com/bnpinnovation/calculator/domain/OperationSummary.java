package com.bnpinnovation.calculator.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationSummary implements Serializable{
	private static final long serialVersionUID = 7256543088980883505L;
	
	private int id;
	private OperationType operationType;
	private int leftOperand;
	private int rightOperand;
	private int result;
	private Date operationDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperationType() {
		return operationType.getOperationSign();
	}
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	public void setOperationType(String operationSign) {
		this.operationType = OperationType.valueFor(operationSign);
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
	@JsonProperty(value="operationDate")
	public String getOperationDate() {
		return  new SimpleDateFormat("yyMMdd HHmmss").format(operationDate);
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + leftOperand;
		result = prime * result
				+ ((operationDate == null) ? 0 : operationDate.hashCode());
		result = prime * result
				+ ((operationType == null) ? 0 : operationType.hashCode());
		result = prime * result + this.result;
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
		OperationSummary other = (OperationSummary) obj;
		if (id != other.id)
			return false;
		if (leftOperand != other.leftOperand)
			return false;
		if (operationDate == null) {
			if (other.operationDate != null)
				return false;
		} else if (!operationDate.equals(other.operationDate))
			return false;
		if (operationType != other.operationType)
			return false;
		if (result != other.result)
			return false;
		if (rightOperand != other.rightOperand)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OperationSummary [id=" + id + ", operationType="
				+ operationType + ", leftOperand=" + leftOperand
				+ ", rightOperand=" + rightOperand + ", result=" + result
				+ ", operationDate=" + operationDate + "]";
	}
	
}
