package com.masaifir.dtos;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	@NotBlank
	@NotEmpty(message = "name required")
	private String firstName;
	
	@NotBlank
	@NotEmpty(message = "name required")
	private String lastName; 
	
	@NotBlank
	@NotEmpty(message = "mobile required")
	private String mobileNumber;
	
	@NotBlank
	@NotEmpty(message = "address required")
	private String address; 
	
	@Min(value = 8, message = "Your age shoul be greater than 8")
	@NotNull
	private Integer age;
	
	@Pattern(regexp = "^(?i)(Male|Female|TransGender)$", message = "gendr should be Male | Female | TransGender")
	private String gender;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "give a strong password")
	private String password;

}
