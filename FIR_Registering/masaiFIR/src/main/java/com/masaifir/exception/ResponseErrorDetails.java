package com.masaifir.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    ResponseErrorDetails class will used to throw user understandable format exception 
    And all setter, getter and constructors are generated using lombok

*/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDetails {

	private LocalDateTime timestamp;
	private String errorMessage;
	private String details;
	
}