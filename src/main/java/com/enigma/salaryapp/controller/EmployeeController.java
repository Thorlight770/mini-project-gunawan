package com.enigma.salaryapp.controller;

import com.enigma.salaryapp.constant.ApiUrlConstant;
import com.enigma.salaryapp.dto.EmployeeSearchDTO;
import com.enigma.salaryapp.entity.Employee;
import com.enigma.salaryapp.service.EmployeeService;
import com.enigma.salaryapp.utils.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlConstant.EMPLOYEE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public PageResponseWrapper<Employee> searchEmployee(@RequestBody EmployeeSearchDTO employeeSearchDTO,
                                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "size", defaultValue = "3") Integer size,
                                                        @RequestParam(name = "sort", defaultValue = "name") String sort,
                                                        @RequestParam(name = "direction", defaultValue = "ASC") String direction){

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort));
        Page<Employee> employeePage = employeeService.getEmployeePerPage(pageable,employeeSearchDTO);
        return new PageResponseWrapper<>(employeePage);
    }

    @PostMapping
    public Employee saveEmployee(Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping
    public Boolean deleteEmployee(String id){
        return employeeService.deleteEmployeeById(id);
    }
}
