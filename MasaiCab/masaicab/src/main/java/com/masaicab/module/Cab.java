package com.masaicab.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cab {
	
	@NotBlank
	@NotEmpty(message = "Name required")
	@Pattern(regexp="^(?i)(Mini|Sedan|SUV)$",message="Car type should be one of the Mini,Sedan and SUV")
	private String  cabType;
	
	@Id
	@Pattern(regexp = "[A-Z]{2}[0-9]{4}", message = "password should look like KA9834, 2 alphabet and 4 numbers ")
	private String cabNo;
	
	@NotBlank
	@NotEmpty(message = "color required")
	private String cabColor;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cab")
	private Driver driver;
	

}
