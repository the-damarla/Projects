package com.example.SundayPracticeTwo.Dto;

public class DepartmentDto {
    private Long id;
    private String name;
    private String code;
    private Long parentDepartment;
    private Long organisationId;
    private Long departmentId;

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

    public Long getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Long parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }
}
