package com.enigma.salaryapp.controller;

import com.enigma.salaryapp.constant.ApiUrlConstant;
import com.enigma.salaryapp.dto.SalarySearchDTO;
import com.enigma.salaryapp.entity.Salary;
import com.enigma.salaryapp.service.SalaryService;
import com.enigma.salaryapp.utils.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlConstant.SALARY)
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping
    public PageResponseWrapper<Salary> searchEmployee(@RequestBody SalarySearchDTO salarySearchDTO,
                                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "size", defaultValue = "3") Integer size,
                                                        @RequestParam(name = "sort", defaultValue = "totalSalary") String sort,
                                                        @RequestParam(name = "direction", defaultValue = "ASC") Sort.Direction direction){

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort));
        Page<Salary> salaryPage = salaryService.getSalaryPerPage(pageable,salarySearchDTO);
        return new PageResponseWrapper<>(salaryPage);
    }

    @PostMapping
    public Salary saveSalary(@RequestBody Salary salary){
        return salaryService.saveSalary(salary);
    }

    @PutMapping
    public Salary updateSalary(@RequestBody Salary salary){
        return salaryService.saveSalary(salary);
    }

    @DeleteMapping
    public Boolean deleteSalary(@RequestParam String id){
        return salaryService.deleteSalaryById(id);
    }
}
