package org.mm.mow.service;


import org.mm.mow.entity.Actor;

import org.mm.mow.repository.ActorRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class AccessService {


	@Autowired
    private ActorRepository actorRepository;


    /***************************************************************************
     Used with Spring Security
     ***************************************************************************/

    public Actor findLoginUser(String username) {

        return actorRepository.findByAddressEmail(username);

    }
    /***************************************************************************/

    /***************************************************************************
     Used without Spring Security
     ***************************************************************************
    public Actor findLoginUser(String username, String password) {

        return actorRepository.findByAddressEmailAndPassword(username, password);

    }
     ***************************************************************************/


}
