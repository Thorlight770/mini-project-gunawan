package com.enigma.salaryapp.service;

import com.enigma.salaryapp.dto.SalarySearchDTO;
import com.enigma.salaryapp.entity.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalaryService {

    Page<Salary> getSalaryPerPage(Pageable pageable, SalarySearchDTO salarySearchDTO);

    Salary saveSalary(Salary salary);

    Salary getSalaryById(String id);

    Boolean deleteSalaryById(String id);
}
