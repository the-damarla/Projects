package com.example.SundayPracticeTwo.Repository;

import com.example.SundayPracticeTwo.Enity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {
    List<Department> findByParentDepartmentId(Long id);
}
