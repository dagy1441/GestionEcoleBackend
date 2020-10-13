package com.gestion.gestionecole.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.AppUser;
import com.gestion.gestionecole.service.implement.AccountService;

@Service
public class CustomUserDetailsService  implements UserDetailsService{
	
	@Autowired AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appUser = accountService.findUserByUserName(username);
		
		if (appUser==null) throw new UsernameNotFoundException(username);
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		appUser.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		
		return new User(appUser.getUserName(),appUser.getPassword(), authorities);
	}


}
