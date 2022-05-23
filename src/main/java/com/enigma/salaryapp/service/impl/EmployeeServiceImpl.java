package com.enigma.salaryapp.service.impl;

import com.enigma.salaryapp.dto.EmployeeSearchDTO;
import com.enigma.salaryapp.entity.Absent;
import com.enigma.salaryapp.entity.Employee;
import com.enigma.salaryapp.repository.EmployeeRepository;
import com.enigma.salaryapp.service.AbsentService;
import com.enigma.salaryapp.service.EmployeeService;
import com.enigma.salaryapp.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AbsentService absentService;

    @Override
    public Page<Employee> getEmployeePerPage(Pageable pageable, EmployeeSearchDTO employeeSearchDTO) {
        Specification<Employee> employeeSpecification = EmployeeSpecification.getSpecification(employeeSearchDTO);
        return employeeRepository.getAllEmployee(employeeSpecification, pageable);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee employeeNew = employeeRepository.save(employee);
        for (Absent absent:employeeNew.getAbsentList()) {
            if (absent.getTimeIn() != null){
                absent.setStatus("present");
            }else {
                absent.setStatus("absent");
            }
            absent.setEmployee(employee);
            absentService.saveAbsent(absent);
        }
        return employeeNew;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id).get();
    }

    @Override
    public String deleteEmployeeById(String id) {
        if (employeeRepository.getEmployeeById(id).isPresent()){
            employeeRepository.deleteById(id);
            return "[SUCCESS DELETED EMPLOYEE]";
        }else {
            return "[FAILED DELETED EMPLOYEE]";
        }
    }
}
