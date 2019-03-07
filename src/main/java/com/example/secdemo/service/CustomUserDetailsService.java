package com.example.secdemo.service;

import com.example.secdemo.model.ApplicationUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = loadAppicationByUsername(username);
        return User.withUsername(applicationUser.getUsername()).password(applicationUser.getPassword()).roles("USER").build();
    }

    public ApplicationUser loadAppicationByUsername(String username){
        return new ApplicationUser("batman", "password");
    }
}
