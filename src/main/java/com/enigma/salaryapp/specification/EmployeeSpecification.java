package com.enigma.salaryapp.specification;

import com.enigma.salaryapp.dto.EmployeeSearchDTO;
import com.enigma.salaryapp.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecification {
    public static Specification<Employee> getSpecification(EmployeeSearchDTO employeeSearchDTO){
        return new Specification<Employee>() {
            List<Predicate> predicateList =new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (employeeSearchDTO.getName() != null){
                    Predicate employeePredicate =criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                            "%" + employeeSearchDTO.getName() + "%");
                    predicateList.add(employeePredicate);
                }

                if (employeeSearchDTO.getAddress() != null){
                    Predicate employeePredicate =criteriaBuilder.like(criteriaBuilder.lower(root.get("address")),
                            "%" + employeeSearchDTO.getAddress() + "%");
                    predicateList.add(employeePredicate);
                }

                if (employeeSearchDTO.getDateOfBirth() != null){
                    Predicate employeePredicate =criteriaBuilder.like(criteriaBuilder.lower(root.get("dateOfBirth")),
                            "%" + employeeSearchDTO.getDateOfBirth() + "%");
                    predicateList.add(employeePredicate);
                }

                Predicate[] predicates = predicateList.toArray(new Predicate[predicateList.size()]);
                return criteriaBuilder.and(predicates);
            }
        };
    }
}
