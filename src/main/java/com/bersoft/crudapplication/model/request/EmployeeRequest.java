package com.bersoft.crudapplication.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String address;
    @Min(18)
    private Integer age;
    @Positive
    @NotNull
    private Double salary;
    @NotBlank
    private String dni;
}
