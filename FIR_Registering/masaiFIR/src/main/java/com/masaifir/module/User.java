package com.masaifir.module;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	
	private static final long serialVersionUID = 4525040373040556195L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	
	private String firstName;
	
	
	private String lastName; 
	
	@Column(unique = true)
	private String mobileNumber;
	
	
	private String address; 
	
	
	private Integer age;
	
	private String gender;
	
	private String password;
	

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
	private List<FIR> firList = new ArrayList<>();
	

}
