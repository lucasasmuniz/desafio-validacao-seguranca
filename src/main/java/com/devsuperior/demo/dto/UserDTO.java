package com.devsuperior.demo.dto;

import java.util.HashSet;
import java.util.Set;

import com.devsuperior.demo.entities.User;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {
	private long id;

	@NotBlank(message = "Campo obrigatório")
	private String email;
	private String password;
	
	Set<RoleDTO> roles = new HashSet<>();
	public UserDTO() {
	}
	
	public UserDTO(long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public UserDTO(User user) {
		id = user.getId();
		email = user.getEmail();
		password = user.getPassword();
		user.getRoles().forEach(role -> this.getRoles().add(new RoleDTO(role)));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}
}
