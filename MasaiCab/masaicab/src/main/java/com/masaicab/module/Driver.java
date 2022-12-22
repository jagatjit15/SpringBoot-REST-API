package com.masaicab.module;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	
	@NotBlank
	@NotEmpty(message = "Name required")
	private String firstName;
	
	@NotBlank
	@NotEmpty(message = "Name required")
	private String lastName;
	
	@NotBlank
	@NotEmpty(message = "mobile number required")
	private String mobileNumber;
	
	
	@NotEmpty(message = "Name required")
	private Integer[] currentPosition = new Integer[2];
	
	@NotBlank
	@NotEmpty(message = "mobile number required")
	private String password;
	
	
	@Column(unique = true)
	@NotNull
	@Pattern(regexp = "[A-Z]{2}[0-9]{8}", message = "password should look like KA98346956, 8 alphabet and 4 numbers ")
	private String drivingLicence;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;

}
