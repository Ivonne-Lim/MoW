package org.mm.mow.repository;


import org.mm.mow.entity.Actor;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

import java.util.List;


@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {


    List<Actor> findByRoleAndStatus(String role, String status, Sort sort);
      // For RegisterService
      // For MealPlanService


    Actor findById(int id);
      // For RegisterService


    Actor findByAddressEmail(String addressEmail);
      // For RegisterService
      // For AccessService (used with Spring Security) and UserDetailServiceImpl

    Actor saveAndFlush(Actor actor);
      // For RegisterService


    Actor findByAddressEmailAndPassword(String addressEmail, String password);
      // For AccessService (used without Spring Security)

 /* @Query(value =
        "SELECT COUNT(role) " +
            "FROM actor " +
            "WHERE role = ?1" +
            "  AND status = ?2", 
            nativeQuery = true) */
    long countByRoleAndStatus(String role, String status);
      // Note: For ReportService


}
