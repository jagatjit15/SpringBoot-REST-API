package com.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDisplay {
	
	  private Integer Id;
	  private String title ;
	  private String body;
	  private Integer userId;

}
