package com.example.SundayPracticeTwo.Controller;

import com.example.SundayPracticeTwo.Dto.DepartmentDto;
import com.example.SundayPracticeTwo.Dto.EmployeeDto;
import com.example.SundayPracticeTwo.Enity.Department;
import com.example.SundayPracticeTwo.Enity.Employee;
import com.example.SundayPracticeTwo.Enity.Organisation;
import com.example.SundayPracticeTwo.Service.DepartmentService;
import com.example.SundayPracticeTwo.Service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping(value = "/{id}")
    EmployeeDto select(@PathVariable("id") Long id)
    {
        Employee employee = employeeService.select(id);
        return copyToDTO(employee);
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    void save(@RequestBody EmployeeDto employeeDto)
    {
        employeeService.save(copyFromDTO(employeeDto));
    }

    @GetMapping(value = "/all")
    Iterable<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping(value = "/byDepartment/{id}")
    Iterable<Employee> findByDepartmentId(@PathVariable("id") Long id)
    {
        return employeeService.findByDepartmentId(id);
    }

    @GetMapping(value = "/countByDepartment/{id}")
    int countByDepartment(@PathVariable("id") Long id)
    {
        Iterable<Employee> employees = employeeService.findByDepartmentId(id);
        int emp = 0;
        for(Employee employee:employees)emp++;
        return emp;
    }

    @GetMapping(value = "/avgOfDepartment/{id}")
    double avgOfDepartment(@PathVariable("id") Long id)
    {
        Iterable<Employee> employees = employeeService.findByDepartmentId(id);
        int sum=0,counter=0;
        for(Employee employee:employees)
        {
            sum += employee.getSalary();
            counter++;
        }
        return sum/counter;
    }

    public Employee copyFromDTO(EmployeeDto employeeDto)
    {
        Employee employee =new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        Department department = departmentService.select(employeeDto.getDepartment());
        employee.setDepartment(department);
        return  employee;
    }

    public EmployeeDto copyToDTO(Employee employee)
    {
        EmployeeDto employeeDto =new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);//copy(source,target)
        Department department = departmentService.select(employee.getDepartment().getId());
        employeeDto.setDepartment(department.getId());
        return employeeDto;
    }
}
