package com.enigma.salaryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeSearchDTO {
    private String name;
    private LocalDate dateOfBirth;
    private String address;
}
