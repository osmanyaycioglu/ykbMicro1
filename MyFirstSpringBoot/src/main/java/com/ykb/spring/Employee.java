package com.ykb.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.ykb.spring.validation.MyCustValid;

@XmlRootElement
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long   empId;

    @MyCustValid(value1 = 5, message = "Name field 5 den büyük olamaz")
    private String name;
    @Size(min = 3, max = 20, message = "Surname 3 ile 20 arasında olmalı")
    private String surname;
    @Max(value = 30, message = "Age 30 dan büyük olamaz")
    private int    age;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }

    public long getEmpId() {
        return this.empId;
    }

    public void setEmpId(final long empIdParam) {
        this.empId = empIdParam;
    }


}
