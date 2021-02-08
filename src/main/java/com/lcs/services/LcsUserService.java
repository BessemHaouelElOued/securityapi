package com.lcs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lcs.entities.LcsUser;
import com.lcs.entities.Role;
import com.lcs.repo.LcsUserRepo;

@Service
public class LcsUserService implements UserDetailsService {

	@Autowired
	LcsUserRepo lcsur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LcsUser u=lcsur.findByUsername(username);
		List<SimpleGrantedAuthority> auths=new ArrayList<>();
		for(Role r:u.getRoles()) {
			auths.add(new SimpleGrantedAuthority(r.getRole()));
		}
		return new User(username, u.getPassword(), auths);
	}

}
