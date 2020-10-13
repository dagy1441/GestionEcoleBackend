package com.gestion.gestionecole.service.implement;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.AppRole;
import com.gestion.gestionecole.models.AppUser;
import com.gestion.gestionecole.repository.AppRoleRepository;
import com.gestion.gestionecole.repository.AppUserRepository;
import com.gestion.gestionecole.service.IAccountService;

@Transactional
@Service
public class AccountService implements IAccountService {
	
	@Autowired AppUserRepository appUserRepo;

	@Autowired AppRoleRepository appRoleRepo;
	
	@Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public AppUser saveUser(String username, String password, String confirmedPassword) {
		
		AppUser user = appUserRepo.findByUserName(username);
		
		if (user != null) throw new RuntimeException("User already exist");

		if (!password.equals(confirmedPassword)) throw new RuntimeException("please confirm your password");
		
		AppUser appUser = new AppUser();
		appUser.setUserName(username);
		appUser.setEnable(true);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		appUserRepo.save(appUser);
		addRoleToUser(username, "USER");
		return appUser;
		
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return appRoleRepo.save(role);
	}

	@Override
	public AppUser findUserByUserName(String username) {
		return appUserRepo.findByUserName(username);
	}

	@Override
	public void addRoleToUser(String username, String role) {
		AppUser appUser = appUserRepo.findByUserName(username);
		AppRole appRole = appRoleRepo.findByRoleName(role);
		appUser.getRoles().add(appRole);
	}

}
