package com.enigma.salaryapp.service.impl;

import com.enigma.salaryapp.dto.AbsentSearchDTO;
import com.enigma.salaryapp.entity.Absent;
import com.enigma.salaryapp.service.AbsentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AbsentServiceImpl implements AbsentService {
    @Override
    public Page<Absent> getAbsentPerPage(Pageable pageable, AbsentSearchDTO absentSearchDTO) {
        return null;
    }

    @Override
    public Absent saveAbsent(Absent absent) {
        return null;
    }

    @Override
    public Absent getAbsentByIdEmployee(String idEmployee) {
        return null;
    }

    @Override
    public Boolean deleteAbsentById(String id) {
        return null;
    }
}
