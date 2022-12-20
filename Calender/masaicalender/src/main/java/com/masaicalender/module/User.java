package com.masaicalender.module;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Email(message = "Enter a valid email")
	private String email;
	

	@NotEmpty
	@NotBlank
	private String password;
	
	@NotBlank(message = "name can not be empty of blank")
	@NotEmpty(message = "name can not be empty of blank")
	private String firstName;
	
	@NotBlank(message = "name can not be empty of blank")
	@NotEmpty(message = "name can not be empty of blank")
	private String lastname;
	
	@NotBlank(message = "number can not be empty of blank")
	@NotEmpty(message = "number can not be empty of blank")
	private String mobileNumber;
	
	@Past(message = "Date of birt can not be in future or present")
	private LocalDate dateOfBirth;
	
	@CreationTimestamp
	private LocalDateTime created;

	@OneToMany(cascade = CascadeType.MERGE)
	@JsonIgnore
	@JoinTable(name = "User_Events")
	private List<Event> eventList = new ArrayList<>();


}
