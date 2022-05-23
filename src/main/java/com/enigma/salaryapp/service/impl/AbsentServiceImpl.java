package com.enigma.salaryapp.service.impl;

import com.enigma.salaryapp.dto.AbsentSearchDTO;
import com.enigma.salaryapp.entity.Absent;
import com.enigma.salaryapp.repository.AbsentRepository;
import com.enigma.salaryapp.service.AbsentService;
import com.enigma.salaryapp.specification.AbsentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AbsentServiceImpl implements AbsentService {
    @Autowired
    private AbsentRepository absentRepository;

    @Override
    public Page<Absent> getAbsentPerPage(Pageable pageable, AbsentSearchDTO absentSearchDTO) {
        Specification<Absent> getSpecification = AbsentSpecification.getSpecification(absentSearchDTO);
        return absentRepository.getAllAbsent(getSpecification, pageable);
    }

    @Override
    public Absent saveAbsent(Absent absent) {
        return absentRepository.save(absent);
    }

    @Override
    public Boolean deleteAbsentById(String id) {
        if (absentRepository.findById(id).isPresent()){
            absentRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
