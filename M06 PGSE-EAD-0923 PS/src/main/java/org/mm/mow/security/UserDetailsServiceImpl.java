package org.mm.mow.security;


import org.mm.mow.entity.Actor;

import org.mm.mow.repository.ActorRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	
    @Autowired
    private ActorRepository actorRepository;


    public UserDetailsServiceImpl() {

        // Default constructor 

    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Actor actor = actorRepository.findByAddressEmail(username);

        if (actor == null) {

        	throw new UsernameNotFoundException("Username (" + username + ") is not valid. Please re-enter.");

        } else {

            UserBuilder userBuilder = User.builder();
            return userBuilder
                .username(actor.getAddressEmail())
                .password(actor.getPassword())
                .roles(actor.getRole().toUpperCase())
                .build();

        }

    }


}
