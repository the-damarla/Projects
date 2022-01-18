package com.example.SundayPracticeTwo.Enity;

import javax.persistence.*;

@Table
@Entity
public class Employee {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false,length = 200)
    private String name;

    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false)
    private Long salary;

    //@Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department departmentId) {
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
