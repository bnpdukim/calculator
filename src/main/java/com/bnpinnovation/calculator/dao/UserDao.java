package com.bnpinnovation.calculator.dao;

import com.bnpinnovation.calculator.domain.CalculatorUser;

public interface UserDao {

	CalculatorUser queryUserByUserName(String username);

}
