package org.mm.mow.service;


import org.mm.mow.entity.Diet;
import org.mm.mow.entity.Actor;

import org.mm.mow.repository.DietRepository;
import org.mm.mow.repository.ActorRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

import java.util.List;


@Service
@Transactional
public class RegisterService {


	@Autowired
    private DietRepository dietRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	
    public List<Diet> findDiets() {

        return dietRepository.findAll(Sort.by(Sort.Direction.ASC, "type"));

    }

    public List<Actor> findCaregivers() {

        return actorRepository.findByRoleAndStatus("Caregiver", "Active", Sort.by(Sort.Direction.ASC, "nameGiven"));

    }


    public Actor findActor(String username) {

        return actorRepository.findByAddressEmail(username);

    }

    public Actor saveActor(Actor actor, String diet_Id, String caregiver_Id) {

        if (diet_Id != null && !diet_Id.equals("")) {
            actor.setDiet(dietRepository.findById(Integer.parseInt(diet_Id)));
        }
        
        if (caregiver_Id != null && !caregiver_Id.equals("")) {
            actor.setCaregiver(actorRepository.findById(Integer.parseInt(caregiver_Id)));
        }

        if (actor.getRole().equals("Member")) {
            if (actor.getDiet() == null) {
                actor.setStatus("Pending");
            } else {
                actor.setStatus("Active");
            }
        }

        if (actor.getRole().equals("FSP")) {
            if (actor.getType() == null) {
                actor.setStatus("Pending");
            } else {
                actor.setStatus("Active");
            }
        }

        if (actor.getRole().equals("Rider")) {
            if (actor.getType() == null) {
                actor.setStatus("Pending");
            } else {
                actor.setStatus("Active");
            }
        }

        if (actor.getStatus() == null) {
            actor.setStatus("Active");
        }

        actor.setAddressLongX(BigDecimal.valueOf(0.0));
        actor.setAddressLatY(BigDecimal.valueOf(0.0));
          // Note: To set addressLongX and addressLatY from Google Geocoding based on addressStreet and addressPostalCode

        actor.setPassword(passwordEncoder.encode(actor.getPassword()));
          // Used with Spring Security

        // actor.setPassword(actor.getPassword());
          // Used without Spring Security

        return actorRepository.saveAndFlush(actor);

    }


}
