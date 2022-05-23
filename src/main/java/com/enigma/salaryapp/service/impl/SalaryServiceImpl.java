package com.enigma.salaryapp.service.impl;

import com.enigma.salaryapp.dto.SalarySearchDTO;
import com.enigma.salaryapp.entity.Salary;
import com.enigma.salaryapp.service.SalaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Override
    public Page<Salary> getSalaryPerPage(Pageable pageable, SalarySearchDTO salarySearchDTO) {
        return null;
    }

    @Override
    public Salary saveSalary(Salary salary) {
        return null;
    }

    @Override
    public Salary getSalaryById(String id) {
        return null;
    }

    @Override
    public Boolean deleteSalaryById(String id) {
        return null;
    }
}
