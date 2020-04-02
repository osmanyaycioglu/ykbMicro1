package com.ykb.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

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


}
