//package com.washer.service;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import com.washer.models.Washer;
//import com.washer.repo.WasherRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private WasherRepository washerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Washer washer = washerRepository.findByName(username);
//        if(washer != null) {
//            GrantedAuthority authority = new SimpleGrantedAuthority(washer.getRole());
//            return new User(washer.getName(), washer.getPassword(), Arrays.asList(authority));
//        }
//        else return new User(null,null,null);
//    }
//}