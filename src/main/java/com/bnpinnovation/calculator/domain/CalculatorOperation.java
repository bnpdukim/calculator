package com.bnpinnovation.calculator.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ofOperation")
public class CalculatorOperation implements Serializable{
	private static final long serialVersionUID = 7256543088980883505L;
	
	@Id
	@Column(name="OPERATION_ID")
	@GeneratedValue
	private Long id;
	
	private OperationType operationType;
	@Column(name="OPERAND_LEFT")
	private int leftOperand;
	@Column(name="OPERAND_RIGHT")
	private int rightOperand;
	@Column(name="OPERATION_RESULT")
	private int result;
	private Date operationDate;
	
	@Column(name="OPERATION")
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
		this.operationDate = new Date();
	}
	
	@Column(name="OPERATION_DATE")
	public String getVisibleDate() {
		return  new SimpleDateFormat("yyMMdd HHmmss").format(operationDate);
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "CalculatorOperation [id=" + id + ", operationType="
				+ operationType + ", leftOperand=" + leftOperand
				+ ", rightOperand=" + rightOperand + ", result=" + result
				+ ", operationDate=" + operationDate + "]";
	}	
}
