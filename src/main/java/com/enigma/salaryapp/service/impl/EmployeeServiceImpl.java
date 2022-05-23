package com.enigma.salaryapp.service.impl;

import com.enigma.salaryapp.dto.EmployeeSearchDTO;
import com.enigma.salaryapp.entity.Employee;
import com.enigma.salaryapp.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Page<Employee> getEmployeePerPage(Pageable pageable, EmployeeSearchDTO employeeSearchDTO) {
        return null;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public Boolean deleteEmployeeById(String id) {
        return null;
    }
}
