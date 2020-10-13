package com.gestion.gestionecole.service;

import com.gestion.gestionecole.models.AppRole;
import com.gestion.gestionecole.models.AppUser;

public interface IAccountService {
	
public AppUser saveUser(String username, String password, String confirmedPassword);
	
	public AppRole saveRole(AppRole role);
	
	public AppUser findUserByUserName(String username);
	
	public void addRoleToUser(String username, String role);

}
