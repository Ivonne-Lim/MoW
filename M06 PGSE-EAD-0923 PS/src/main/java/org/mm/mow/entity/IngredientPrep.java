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

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "ingredientprep", uniqueConstraints = {@UniqueConstraint(columnNames = {"ingredient", "mealprep_id"})})

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class IngredientPrep {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "mealprep_id")
	private MealPrep mealPrep;

    @NotEmpty(message = "Ingredient should not be empty.")
    @Size(message = "Ingredient should not be greater than 40 characters.", min = 0, max = 40)

	@Column(name = "ingredient", nullable = false, unique = false, length = 40)
	private String ingredient;

	@Column(name = "quantity", nullable = false, unique = false)
	private int quantity;

    @NotEmpty(message = "UOM should not be empty.")
    @Size(message = "UOM should not be greater than 10 characters.", min = 0, max = 10)

	@Column(name = "uom", nullable = false, unique = false, length = 10)
	private String uom;

    @NotEmpty(message = "Status should not be empty.")
    @Size(message = "Status should not be greater than 20 characters.", min = 0, max = 20)

	@Column(name = "status", nullable = false, unique = false, length = 20)
	private String status;


}
