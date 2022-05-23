package com.enigma.salaryapp.specification;

import com.enigma.salaryapp.dto.AbsentSearchDTO;
import com.enigma.salaryapp.dto.EmployeeSearchDTO;
import com.enigma.salaryapp.entity.Absent;
import com.enigma.salaryapp.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AbsentSpecification {
    public static Specification<Absent> getSpecification(AbsentSearchDTO absentSearchDTO){
        return new Specification<Absent>() {
            List<Predicate> predicateList =new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Absent> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (absentSearchDTO.getIdCustomer() != null){
                    Predicate absentPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("idCustomer")),
                            "%" + absentSearchDTO.getIdCustomer() + "%");
                    predicateList.add(absentPredicate);
                }

                if (absentSearchDTO.getTimeIn() != null && absentSearchDTO.getTimeOut() != null){
                    Predicate absentPredicate = criteriaBuilder.between(root.get("timeIn"), absentSearchDTO.getTimeIn(), absentSearchDTO.getTimeOut());
                    predicateList.add(absentPredicate);
                }

                Predicate[] predicates = predicateList.toArray(new Predicate[predicateList.size()]);
                return criteriaBuilder.and(predicates);
            }
        };
    }
}
