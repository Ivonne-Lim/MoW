package org.mm.mow.service;


import org.mm.mow.entity.Diet;
import org.mm.mow.entity.Actor;
import org.mm.mow.entity.MealPlan;

import org.mm.mow.repository.DietRepository;
import org.mm.mow.repository.ActorRepository;
import org.mm.mow.repository.MealPlanRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;


@Service
@Transactional
public class MealPlanService {


    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private ActorRepository actorRepository;

	@Autowired
    private MealPlanRepository mealPlanRepository;


	public List<Diet> findDiets() {

	    return dietRepository.findAll(Sort.by(Sort.Direction.ASC, "type"));

	}

    public List<Actor> findFsps() {

        return actorRepository.findByRoleAndStatus("FSP", "Active", Sort.by(Sort.Direction.ASC, "nameGiven"));

    }


    public List<MealPlan> findMealPlans() {

        return mealPlanRepository.findAll(Sort.by(Sort.Direction.ASC, "sequence").and(Sort.by(Sort.Direction.ASC, "diet")));

    }


    public MealPlan findMealPlan(int id) {

        return mealPlanRepository.findById(id);

    }

    public MealPlan saveMealPlan(MealPlan mealPlan, String diet_Id, String fsp_Id) {

        mealPlan.setDiet(dietRepository.findById(Integer.parseInt(diet_Id)));

        mealPlan.setFsp(actorRepository.findById(Integer.parseInt(fsp_Id)));

        return mealPlanRepository.saveAndFlush(mealPlan);

    }

    public void deleteMealPlan(int id) {

        mealPlanRepository.deleteById(id);

    }


}
