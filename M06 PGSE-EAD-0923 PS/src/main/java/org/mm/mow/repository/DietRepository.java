package org.mm.mow.repository;


import org.mm.mow.entity.Diet;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import java.util.List;


@Repository
public interface DietRepository extends JpaRepository<Diet, Integer> {


    List<Diet> findAll(Sort sort);
      // For RegisterService


    Diet findById(int id);
      // For RegisterService


}
