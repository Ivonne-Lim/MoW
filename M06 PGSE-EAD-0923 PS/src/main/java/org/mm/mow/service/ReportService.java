package org.mm.mow.service;


import org.mm.mow.entity.Actor;

import org.mm.mow.repository.ActorRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;


@Service
@Transactional
public class ReportService {


    @Autowired
    private ActorRepository actorRepository;


	public long countActorsByRole(String role) {

	    return actorRepository.countByRoleAndStatus(role, "Active");

	}


}
