package com.example.SundayPracticeTwo.Service;

import com.example.SundayPracticeTwo.Dto.EmployeeDto;
import com.example.SundayPracticeTwo.Enity.Employee;

import java.util.EnumMap;

public interface EmployeeService {
    void save(Employee employee);
    Employee select(Long id);
    Iterable<Employee> findAll();
    Iterable<Employee> findByDepartmentId(Long id);
}
