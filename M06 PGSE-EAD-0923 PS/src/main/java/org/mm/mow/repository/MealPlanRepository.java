package org.mm.mow.repository;


import org.mm.mow.entity.MealPlan;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import java.util.List;


@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Integer> {


    List<MealPlan> findAll(Sort sort);
      // For MealPlanService


    MealPlan findById(int id);
      // For MealPlanService

    MealPlan saveAndFlush(MealPlan mealPlan);
      // For MealPlanService

    void deleteById(int id);
      // For MealPlanService

}
