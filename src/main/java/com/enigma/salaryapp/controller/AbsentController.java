package com.enigma.salaryapp.controller;

import com.enigma.salaryapp.constant.ApiUrlConstant;
import com.enigma.salaryapp.dto.AbsentSearchDTO;
import com.enigma.salaryapp.entity.Absent;
import com.enigma.salaryapp.service.AbsentService;
import com.enigma.salaryapp.utils.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlConstant.ABSENT)
public class AbsentController {
    @Autowired
    private AbsentService absentService;

    @GetMapping
    public PageResponseWrapper<Absent> searchAbsent(@RequestBody AbsentSearchDTO absentSearchDTO,
                                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "size", defaultValue = "3") Integer size,
                                                        @RequestParam(name = "sort", defaultValue = "id") String sort,
                                                        @RequestParam(name = "direction", defaultValue = "ASC") Sort.Direction direction){

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort));
        Page<Absent> absentPage = absentService.getAbsentPerPage(pageable,absentSearchDTO);
        return new PageResponseWrapper<>(absentPage);
    }

    @PostMapping
    public Absent saveAbsent(@RequestBody Absent absent){
        return absentService.saveAbsent(absent);
    }

    @PutMapping
    public Absent updateAbsent(@RequestBody Absent absent){
        return absentService.saveAbsent(absent);
    }

    @DeleteMapping
    public Boolean deleteAbsent(@RequestParam String id){
        return absentService.deleteAbsentById(id);
    }
}
