package org.mm.mow.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "actor")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Actor {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "caregiver_id")
	private Actor caregiver;

	@ManyToOne
	@JoinColumn(name = "diet_id")
	private Diet diet;

    @NotEmpty(message = "Given Name should not be empty.")
    @Size(message = "Given Name should not be greater than 40 characters.", min = 0, max = 40)

    @Column(name = "namegiven", nullable = false, unique = false, length = 40)
	private String nameGiven;

    @Size(message = "Family Name should not be greater than 40 characters.", min = 0, max = 40)

    @Column(name = "namefamily", nullable = true, unique = false, length = 40)
	private String nameFamily;

    @NotEmpty(message = "Email Address should not be empty.")
    @Size(message = "Email Address should not be greater than 40 characters.", min = 0, max = 40)
    @Email(message = "Email Address should be valid.")

    @Column(name = "addressemail", nullable = false, unique = true, length = 40)
	private String addressEmail;

    @NotEmpty(message = "Password should not be empty.")
    @Size(message = "Password should not be greater than 64 characters.", min = 0, max = 64)

	@Column(name = "password", nullable = false, unique = false, length = 64)
	private String password;

    @NotEmpty(message = "Role should not be empty.")
    @Size(message = "Role should not be greater than 10 characters.", min = 0, max = 10)

	@Column(name = "role", nullable = false, unique = false, length = 10)
	private String role;

    @Size(message = "Type should not be greater than 10 characters.", min = 0, max = 10)

	@Column(name = "type", nullable = true, unique = false, length = 10)
	private String type;

    @NotEmpty(message = "Contact should not be empty.")
    @Size(message = "Contact should not be greater than 10 characters.", min = 0, max = 10)

	@Column(name = "contact", nullable = false, unique = false, length = 10)
	private String contact;

    @NotEmpty(message = "Street Address should not be empty.")
    @Size(message = "Street Address should not be greater than 255 characters.", min = 0, max = 255)

	@Column(name = "addressstreet", nullable = false, unique = false, length = 255)
	private String addressStreet;

    @Size(message = "Unit should not be greater than 10 characters.", min = 0, max = 10)

	@Column(name = "addressunit", nullable = true, unique = false, length = 10)
	private String addressUnit;

    @NotEmpty(message = "Postal Code should not be empty.")
    @Size(message = "Postal Code should not be greater than 6 characters.", min = 0, max = 6)
    @Pattern(message = "Postal Code should be valid.", regexp = "\\d{6}")

	@Column(name = "addresspostal", nullable = false, unique = false, length = 6)
	private String addressPostal;

	@Column(name = "addresslongx", nullable = false, unique = false, precision = 10, scale = 6)
	private BigDecimal addressLongX;

	@Column(name = "addresslaty", nullable = false, unique = false, precision = 10, scale = 6)
	private BigDecimal addressLatY;

    @NotEmpty(message = "Status should not be empty.")
    @Size(message = "Status should not be greater than 20 characters.", min = 0, max = 20)

	@Column(name = "status", nullable = false, unique = false, length = 20)
	private String status;

    @Size(message = "Note should not be greater than 255 characters.", min = 0, max = 255)

	@Column(name = "note", nullable = true, unique = false, length = 255)
	private String note;


	@OneToMany(mappedBy = "caregiver", cascade = CascadeType.ALL)
	private List<Actor> members = new ArrayList<>();

	@OneToMany(mappedBy = "fsp", cascade = CascadeType.ALL)
	private List<MealPlan> mealPlans = new ArrayList<>();

	@OneToMany(mappedBy = "fsp", cascade = CascadeType.ALL)
	private List<MealPrep> mealPreps = new ArrayList<>();

	@OneToMany(mappedBy = "rider", cascade = CascadeType.ALL)
	private List<Delivery> deliveriesByRider = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Delivery> deliveriesForMember = new ArrayList<>();


}
