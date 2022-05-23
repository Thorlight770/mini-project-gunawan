package com.enigma.salaryapp.service;

import com.enigma.salaryapp.dto.AbsentSearchDTO;
import com.enigma.salaryapp.entity.Absent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbsentService {

    Page<Absent> getAbsentPerPage(Pageable pageable, AbsentSearchDTO absentSearchDTO);

    Absent saveAbsent(Absent absent);

    Boolean deleteAbsentById(String id);
}
