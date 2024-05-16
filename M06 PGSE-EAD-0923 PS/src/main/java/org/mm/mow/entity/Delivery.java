package org.mm.mow.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

import java.sql.Timestamp;


@Entity
@Table(name = "delivery")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Delivery {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "mealprep_id")
	private MealPrep mealPrep;

	@ManyToOne
	@JoinColumn(name = "rider_id")
	private Actor rider;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Actor member;

    @NotEmpty(message = "Meal State should not be empty.")
    @Size(message = "Meal State should not be greater than 10 characters.", min = 0, max = 10)

	@Column(name = "mealstate", nullable = false, unique = false, length = 10)
	private String mealState;

    @NotEmpty(message = "Status should not be empty.")
    @Size(message = "Status should not be greater than 20 characters.", min = 0, max = 20)

	@Column(name = "status", nullable = false, unique = false, length = 20)
	private String status;

	@Column(name = "datetimeopened", nullable = false, unique = false)
	private Timestamp dateTimeOpened;

	@Column(name = "datetimeclosed", nullable = true, unique = false)
	private Timestamp dateTimeClosed;

	@Column(name = "ratingdelivery", nullable = true, unique = false)
	private int ratingDelivery;

    @Size(message = "Delivery Feedback should not be greater than 255 characters.", min = 0, max = 255)

	@Column(name = "feedbackdelivery", nullable = true, unique = false, length = 255)
	private String feedbackDelivery;


}
