package com.example.SundayPracticeTwo.Controller;

import com.example.SundayPracticeTwo.Dto.DepartmentDto;
import com.example.SundayPracticeTwo.Enity.Department;
import com.example.SundayPracticeTwo.Enity.Organisation;
import com.example.SundayPracticeTwo.Service.DepartmentService;
import com.example.SundayPracticeTwo.Service.OrganisationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    OrganisationService organisationService;

    @GetMapping(value = "/{id}")
    DepartmentDto select(@PathVariable("id") Long id)
    {
        Department department = departmentService.select(id);
        return copyToDTO(department);
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    void save(@RequestBody DepartmentDto departmentDto)
    {
        departmentService.save(copyFromDTO(departmentDto));
    }

    @GetMapping(value = "/all")
    Iterable<Department> findAll()
    {
        return departmentService.findAll();
    }

    @GetMapping(value = "/byParentId/{id}")
    List<Department> findByParentId(@PathVariable("id")Long id)
    {
        return departmentService.findByParentDepartmentID(id);
    }

    public Department copyFromDTO(DepartmentDto departmentDto)
    {
        Department department =new Department();
        BeanUtils.copyProperties(departmentDto,department);
        Organisation organisation=organisationService.select(departmentDto.getOrganisationId());
        Department department1 = departmentService.select(departmentDto.getParentDepartment());
        department.setOrganisationId(organisation);
        department.setParentDepartment(department1);
        return  department;
    }

    public DepartmentDto copyToDTO(Department department)
    {
        DepartmentDto departmentDto =new DepartmentDto();
        BeanUtils.copyProperties(department,departmentDto);//copy(source,target)
        Organisation organisation=organisationService.select(department.getOrganisationId().getId());
        departmentDto.setOrganisationId(organisation.getId());
        Department department1 = departmentService.select(department.getParentDepartment().getId());
        departmentDto.setParentDepartment(department1.getId());
        return departmentDto;
    }
}
