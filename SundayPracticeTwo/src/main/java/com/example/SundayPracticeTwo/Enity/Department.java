package com.example.SundayPracticeTwo.Enity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table
@Entity
public class Department {
    @Id
    @GeneratedValue(generator = "gen_alias")
    @GenericGenerator(name = "gen_alias",strategy = "increment")
    private Long id;

    @Column(length = 400,nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;


//    @Column(length = 50)
    @ManyToOne
    @JoinColumn(name = "parent_department_id",referencedColumnName = "id")
    private Department parentDepartment;

//    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "organisation_id",referencedColumnName = "id")
    private Organisation organisationId;

    private Long departmentId;


    public Department getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Organisation getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Organisation organisationId) {
        this.organisationId = organisationId;
    }
}
