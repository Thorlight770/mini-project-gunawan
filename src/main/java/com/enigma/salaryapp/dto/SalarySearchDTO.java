package com.enigma.salaryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class SalarySearchDTO {
    private String employeeId;
    private Integer totalSalary;
    private LocalDateTime dateSalary;
}
