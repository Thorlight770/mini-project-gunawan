package com.enigma.salaryapp.repository;

import com.enigma.salaryapp.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    Page<Employee> getAllEmployee(Specification<Employee> specification, Pageable pageable);

    @Query(value = "INSERT INTO employee (id,name,date,address) VALUES (?1,?2,?3,?4)", nativeQuery = true)
    Employee createEmployee(String id,String name, LocalDate date, String address);

    @Query(value = "SELECT * FROM employee WHERE id = ?1", nativeQuery = true)
    Optional<Employee> getEmployeeById(String id);

    @Query(value = "delete from employee where id=?1", nativeQuery = true)
    void deleteEmployee(String id);
}
