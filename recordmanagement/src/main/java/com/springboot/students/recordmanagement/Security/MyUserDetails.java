package com.springboot.students.recordmanagement.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.springboot.students.recordmanagement.Entity.Roles;
import com.springboot.students.recordmanagement.Entity.Users;

public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails{

	private Users user;

	public MyUserDetails(Users user) {
		this.user = user;
	}
//Fetching Authorities details based upon role associated to a particular user
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Roles> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for(Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
