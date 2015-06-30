package com.bnpinnovation.calculator.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.bnpinnovation.calculator.dao.RoleDao;
import com.bnpinnovation.calculator.domain.Role;

@Repository
public class RoleDaoImpl  extends AbstractDao implements RoleDao{

	@Override
	public Role getRole(Long id) {
		return (Role) getSession().load(Role.class, id);
	}

}
