package com.enigma.salaryapp.repository;

import com.enigma.salaryapp.entity.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, String>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM salary", nativeQuery = true)
    Page<Salary> getAllSalary(Specification<Salary> specification, Pageable pageable);

    @Query(value = "SELECT * FROM salary WHERE id = ?1", nativeQuery = true)
    Optional<Salary> getSalaryById(String id);
}
