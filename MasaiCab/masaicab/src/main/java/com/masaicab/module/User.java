package com.masaicab.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotBlank
	@NotEmpty(message = "Name required")
	private String firstName;
	
	@NotBlank
	@NotEmpty(message = "Name required")
	private String lastName;
	
	@Column(unique = true)
	@NotBlank
	@NotEmpty(message = "mobile number required")
	private String mobileNumber;
	
	
	@NotEmpty(message = "Name required")
	private Integer[] currentPosition = new Integer[2];
	
	@NotBlank
	@NotEmpty(message = "mobile number required")
	private String password;
	
	
	
}
