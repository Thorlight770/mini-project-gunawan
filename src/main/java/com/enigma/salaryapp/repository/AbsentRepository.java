package com.enigma.salaryapp.repository;

import com.enigma.salaryapp.entity.Absent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsentRepository extends JpaRepository<Absent, String>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM absent", nativeQuery = true)
    Page<Absent> getAllAbsent(Specification<Absent> specification, Pageable pageable);
}
