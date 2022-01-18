package com.example.SundayPracticeTwo.Service.Implementations;

import com.example.SundayPracticeTwo.Enity.Employee;
import com.example.SundayPracticeTwo.Repository.EmployeeRepository;
import com.example.SundayPracticeTwo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> findByDepartmentId(Long id) {
        return employeeRepository.findByDepartmentId(id);
    }

    @Override
    public Employee select(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
