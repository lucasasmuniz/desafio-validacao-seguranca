package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Role;

public class RoleDTO {
	private long id;
	private String authority;
	
	public RoleDTO() {
	}
	
	public RoleDTO(long id, String authority) {
		this.id = id;
		this.authority = authority;
	}
	
	public RoleDTO(Role role) {
		id = role.getId();
		authority = role.getAuthority();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
