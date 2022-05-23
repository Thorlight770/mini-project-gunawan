package com.enigma.salaryapp.repository;

import com.enigma.salaryapp.entity.Absent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsentRepository extends JpaRepository<Absent, String>, JpaSpecificationExecutor {
}
