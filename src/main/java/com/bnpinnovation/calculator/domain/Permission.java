package com.bnpinnovation.calculator.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "ofPermission")
public class Permission implements GrantedAuthority{
	private static final long serialVersionUID = -4940721807420604234L;

	@Id
	@Column(name = "PERMISSION_ID")
	@GeneratedValue
	private Long id;
	
	@Column(name = "PERMISSION_NAME", nullable = false)
	private String permissionName;

	@Override
	public String getAuthority() {
		return permissionName;
	}
}
