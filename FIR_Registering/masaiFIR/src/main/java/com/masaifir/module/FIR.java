package com.masaifir.module;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FIR implements Serializable{

	private static final long serialVersionUID = -5599314308747620562L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer firId;
	
	@NotBlank
	@NotEmpty
	private String crimeDetail;
	
	@CreationTimestamp
	private LocalDateTime timeStamp;
	
	@NotBlank
	@NotEmpty(message = "Required a policestation")
	private String policeStation;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;

}
