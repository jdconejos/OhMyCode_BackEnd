package com.ohmycode.security;

import java.util.ArrayList;

import com.ohmycode.domain.models.Address;
import com.ohmycode.domain.models.UserDao;
import com.ohmycode.domain.repositories.UserRepository;
import com.ohmycode.rest.DTOs.DTOAuthUser;
import com.ohmycode.rest.DTOs.DTOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDao user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public UserDao save(DTOAuthUser user) {

        Address newAddress = new Address();
        newAddress.setId(user.getAddress().getId());
        newAddress.setCity(user.getAddress().getCity());
        newAddress.setCountry(user.getAddress().getCountry());
        newAddress.setZipcode(user.getAddress().getZipcode());
        newAddress.setStreet(user.getAddress().getStreet());

        UserDao newUser = new UserDao();

        newUser.setAddress(newAddress);
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }

}


