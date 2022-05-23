package com.enigma.salaryapp.service.impl;

import com.enigma.salaryapp.dto.SalarySearchDTO;
import com.enigma.salaryapp.entity.Absent;
import com.enigma.salaryapp.entity.Employee;
import com.enigma.salaryapp.entity.Salary;
import com.enigma.salaryapp.repository.SalaryRepository;
import com.enigma.salaryapp.service.EmployeeService;
import com.enigma.salaryapp.service.SalaryService;
import com.enigma.salaryapp.specification.SalarySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public Page<Salary> getSalaryPerPage(Pageable pageable, SalarySearchDTO salarySearchDTO) {
        Specification<Salary> specification = SalarySpecification.getSpecification(salarySearchDTO);
        return salaryRepository.findAll(specification, pageable);
    }

    @Override
    public Salary saveSalary(Salary salary) {
        Employee employee = employeeService.getEmployeeById(salary.getEmployee().getId());
        AtomicReference<Integer> totalSalary = new AtomicReference<>(0);
        if (salary.getEmployee().getId() != null){
            List<Absent> absentList = employee.getAbsentList();
            absentList.stream().filter(e ->
                            e.getDate().getMonth().equals(salary.getSalaryDate().getMonth()) &&
                            e.getDate().getYear() == salary.getSalaryDate().getYear())
                    .forEach(y -> totalSalary.updateAndGet(v -> v + 3000));
            salary.setTotalSalary(totalSalary.get());
            return salaryRepository.save(salary);
        }else {
            return null;
        }
    }

    @Override
    public Salary getSalaryById(String id) {
        return salaryRepository.getSalaryById(id).get();
    }

    @Override
    public Boolean deleteSalaryById(String id) {
        if (salaryRepository.findById(id).isPresent()){
            salaryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
