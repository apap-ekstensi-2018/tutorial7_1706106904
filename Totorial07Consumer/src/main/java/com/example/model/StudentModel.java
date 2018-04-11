package com.example.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel
{
	@NotNull
    private String npm;
    
	@NotNull
	@Size(min=2, max=30)
    private String name;
	
	@NotNull
	@Min(1)@Max(4)
    private Double gpa;

}
