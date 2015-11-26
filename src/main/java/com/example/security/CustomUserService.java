package com.example.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.service.AccountService;


@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	private AccountService accountService;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountService.findByUsername(username);
		
        List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(account.getRole()));
		
        return new User(account.getUsername(), account.getPassword(), authorities);
    }
}
