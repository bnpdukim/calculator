package com.bnpinnovation.calculator.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="ofCalculatorUser")
public class CalculatorUser {
	@Id
	@Column(name="USER_ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="USERNAME")
	private String userName;
	@Column(name="PASSWORD")
	private String password;
	
	@ManyToMany
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<Role>();
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Set<Role> getRoles() {
		
		return roles;
	}

	public Long getId() {
		return id;
	}

}
