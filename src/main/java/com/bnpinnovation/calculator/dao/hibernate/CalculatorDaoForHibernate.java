package com.bnpinnovation.calculator.dao.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bnpinnovation.calculator.dao.CalculatorDao;
import com.bnpinnovation.calculator.domain.CalculatorOperation;

@Repository
public class CalculatorDaoForHibernate extends AbstractDao implements CalculatorDao {

	@Override
	public Long insertCalculatorOperation(CalculatorOperation operation) {
		return (Long)getSession().save(operation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<CalculatorOperation> queryOperationSummary() {
		Query query = getSession().createQuery("from CalculatorOperation");
		return new HashSet<CalculatorOperation>(query.list());
	}

}
