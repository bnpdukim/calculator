package com.bnpinnovation.calculator.service.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpinnovation.calculator.dao.UserDao;
import com.bnpinnovation.calculator.domain.CalculatorUser;
import com.bnpinnovation.calculator.domain.Role;


@Service
@Transactional(readOnly=true)
public class CalculatorUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		CalculatorUser calculatorUser = userDao.queryUserByUserName(username);
		
		boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        return new User(
        		calculatorUser.getUserName(), 
                calculatorUser.getPassword(), 
                enabled, 
                accountNonExpired, 
                credentialsNonExpired, 
                accountNonLocked,
                getAuthorities(calculatorUser.getRoles())
        );
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		for(Role role : roles) {	
			authorities.addAll(role.getPermissions());
		}
		
		return authorities;
	}

}
