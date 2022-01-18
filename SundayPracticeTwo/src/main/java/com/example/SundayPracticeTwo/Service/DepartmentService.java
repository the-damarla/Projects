package com.example.SundayPracticeTwo.Service;

import com.example.SundayPracticeTwo.Dto.DepartmentDto;
import com.example.SundayPracticeTwo.Enity.Department;

import java.util.List;

public interface DepartmentService {
    Department select(Long id);
    void save(Department department);
    Iterable<Department> findAll();
    List<Department> findByParentDepartmentID(Long id);
}
