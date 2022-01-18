package com.example.SundayPracticeTwo.Enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Organisation {
    @Id
    @Column(nullable = false)
    Long id;

    @Column(nullable = false,length = 250)
    String name;

    @Column(nullable = false,unique = true)
    String code;

    @Column(length = 500)
    String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
