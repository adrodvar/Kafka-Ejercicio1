package com.example.Entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer phone;
    @Column
    private String passport;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer id, String name, Integer phone, String passport) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.passport = passport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
