package org.mm.mow.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "mealplan", uniqueConstraints = {@UniqueConstraint(columnNames = {"fsp_id", "diet_id", "sequence"})})

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MealPlan {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "fsp_id")
	private Actor fsp;

	@ManyToOne
	@JoinColumn(name = "diet_id")
	private Diet diet;

	@Column(name = "sequence", nullable = false, unique = false)
	private int sequence;

    @NotEmpty(message = "Meal should not be empty.")
    @Size(message = "Meal should not be greater than 40 characters.", min = 0, max = 40)

	@Column(name = "meal", nullable = false, unique = false, length = 40)
	private String meal;


	@OneToMany(mappedBy = "mealPlan", cascade = CascadeType.ALL)
	private List<IngredientPlan> ingredientPlans = new ArrayList<>();


}
