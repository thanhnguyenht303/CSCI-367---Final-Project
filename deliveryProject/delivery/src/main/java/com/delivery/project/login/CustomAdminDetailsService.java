package com.delivery.project.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAdminDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = repo.findByUsername(username);
        if(admin == null){
            throw new UsernameNotFoundException("No user found with the given username");
        }
        return new CustomAdminDetail(admin);
    }
}
