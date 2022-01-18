package com.example.SundayPracticeTwo.Dto;


public class EmployeeDto {
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private Long age;
    private Long salary;
    private Long department;

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long departmentId) {
        this.department = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
