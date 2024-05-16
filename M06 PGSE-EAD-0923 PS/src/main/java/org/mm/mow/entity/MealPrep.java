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

import java.sql.Timestamp;

import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "mealprep", uniqueConstraints = {@UniqueConstraint(columnNames = {"fsp_id", "diet_id", "sequence"})})

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MealPrep {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "fsp_id")
	private Actor fsp;

	@ManyToOne
	@JoinColumn(name = "diet_id")
	private Diet diet;

	@Column(name = "sequence", nullable = false)
	private int sequence;

    @NotEmpty(message = "Meal should not be empty.")
    @Size(message = "Meal should not be greater than 40 characters.", min = 0, max = 40)

	@Column(name = "meal", nullable = false, unique = false, length = 40)
	private String meal;

    @NotEmpty(message = "Status should not be empty.")
    @Size(message = "Status should not be greater than 20 characters.", min = 0, max = 20)

	@Column(name = "status", nullable = false, unique = false, length = 20)
	private String status;

	@Column(name = "datetimeopened", nullable = false, unique = false)
	private Timestamp dateTimeOpened;

	@Column(name = "datetimesup", nullable = true, unique = false)
	private Timestamp dateTimeSup;

	@Column(name= "datetimeprep", nullable = true, unique = false)
	private Timestamp dateTimePrep;

	@Column(name = "datetimeclosed", nullable = true, unique = false)
	private Timestamp dateTimeClosed;

	@Column(name = "ratingmeal", nullable = true, unique = false)
	private int ratingMeal;

    @Size(message = "Meal Feedback should not be greater than 255 characters.", min = 0, max = 255)

	@Column(name = "feedbackmeal", nullable = true, unique = false, length = 255)
	private String feedbackMeal;


	@OneToMany(mappedBy = "mealPrep", cascade = CascadeType.ALL)
	private List<IngredientPrep> ingredientPreps = new ArrayList<>();


}
