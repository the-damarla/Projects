package com.example.SundayPracticeTwo.Service.Implementations;

import com.example.SundayPracticeTwo.Dto.DepartmentDto;
import com.example.SundayPracticeTwo.Enity.Department;
import com.example.SundayPracticeTwo.Repository.DepartmentRepository;
import com.example.SundayPracticeTwo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> findByParentDepartmentID(Long id) {
        return departmentRepository.findByParentDepartmentId(id);
    }

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department select(Long id) {
        return departmentRepository.findById(id).get();
    }
}
