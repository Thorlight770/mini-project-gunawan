package com.enigma.salaryapp.repository;

import com.enigma.salaryapp.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, String>, JpaSpecificationExecutor {
}
