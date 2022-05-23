package com.enigma.salaryapp.specification;

import com.enigma.salaryapp.dto.SalarySearchDTO;
import com.enigma.salaryapp.entity.Salary;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SalarySpecification {
    public static Specification<Salary> getSpecification(SalarySearchDTO salarySearchDTO){
        return new Specification<Salary>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Salary> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
