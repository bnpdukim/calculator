package com.bnpinnovation.calculator.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Repository;

import com.bnpinnovation.calculator.dao.UserDao;
import com.bnpinnovation.calculator.domain.CalculatorUser;

@Repository
public class UserDaoImpl  extends AbstractDao implements UserDao{

	@Override
	public CalculatorUser queryUserByUserName(String username) {
		Criteria criteria = getSession().createCriteria(CalculatorUser.class);
		criteria.add(Restrictions.eq("userName", username));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
		CalculatorUser user = (CalculatorUser)criteria.uniqueResult();
		
		if(user == null ) {
			throw new DataAccessResourceFailureException("not exist");
		}
		
        return user;
	}

	

}
