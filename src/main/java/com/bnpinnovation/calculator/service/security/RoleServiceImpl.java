package com.bnpinnovation.calculator.service.security;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpinnovation.calculator.dao.RoleDao;
import com.bnpinnovation.calculator.domain.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	@Override
	public Role getRole(Long id) {
		return roleDao.getRole(id);
	}

}
