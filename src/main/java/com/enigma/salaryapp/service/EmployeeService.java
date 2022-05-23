package com.enigma.salaryapp.service;

import com.enigma.salaryapp.dto.EmployeeSearchDTO;
import com.enigma.salaryapp.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<Employee> getEmployeePerPage(Pageable pageable, EmployeeSearchDTO employeeSearchDTO);

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
