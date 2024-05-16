package org.mm.mow.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
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
@Table(name = "sysparameter")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SysParameter {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @NotEmpty(message = "Purpose should not be empty.")
    @Size(message = "Purpose should not be greater than 40 characters.", min = 0, max = 40)

	@Column(name = "purpose", nullable = false, unique = true, length = 40)
	private String purpose;

	@Column(name = "value", nullable = false, unique = false)
	private int value;


}
