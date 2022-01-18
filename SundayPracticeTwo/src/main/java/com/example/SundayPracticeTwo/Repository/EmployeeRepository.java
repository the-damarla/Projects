package com.example.SundayPracticeTwo.Repository;

import com.example.SundayPracticeTwo.Enity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    Iterable<Employee> findByDepartmentId(Long id);
}
