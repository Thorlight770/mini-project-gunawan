package com.enigma.salaryapp.specification;

import com.enigma.salaryapp.dto.SalarySearchDTO;
import com.enigma.salaryapp.entity.Employee;
import com.enigma.salaryapp.entity.Salary;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class SalarySpecification {
    public static Specification<Salary> getSpecification(SalarySearchDTO salarySearchDTO){
        return new Specification<Salary>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Salary> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (salarySearchDTO.getEmployeeId() != null){
                    Join<Salary, Employee> join = root.join("employee", JoinType.INNER);
                    join.on(criteriaBuilder.like(join.get("id"), "%" +salarySearchDTO.getEmployeeId()+"%"));
                    Predicate predicate = join.getOn();
                    predicates.add(predicate);
                }

                if (salarySearchDTO.getDateSalary() != null){
                    Predicate predicate = criteriaBuilder.like(root.get("salaryDate"), "%" +salarySearchDTO.getDateSalary()+ "%");
                    predicates.add(predicate);
                }

                if (salarySearchDTO.getTotalSalaryMin() != null && salarySearchDTO.getTotalSalaryMax() != null){
                    Predicate predicate = criteriaBuilder.between(root.get("totalSalary"),
                            salarySearchDTO.getTotalSalaryMin(),
                            salarySearchDTO.getTotalSalaryMax());
                    predicates.add(predicate);
                }

                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
