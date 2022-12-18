package com.masaifir.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirDto {
	
	@NotBlank
	@NotEmpty
	private String crimeDetail;
	
	
	@NotBlank
	@NotEmpty(message = "Required a policestation")
	private String policeStation;

}
