package org.mm.mow.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "diet")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Diet {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @NotEmpty(message = "Type should not be empty.")
    @Size(message = "Type should not be greater than 10 characters.", min = 0, max = 10)

    @Column(name = "type", nullable = false, unique = true, length = 10)
	private String type;


	@OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
	private List<Actor> members = new ArrayList<>();

	@OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
	private List<MealPlan> mealPlans = new ArrayList<>();

	@OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
	private List<MealPrep> mealPreps = new ArrayList<>();


}
